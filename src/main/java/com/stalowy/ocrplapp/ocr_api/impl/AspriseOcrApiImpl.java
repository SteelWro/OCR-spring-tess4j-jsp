package com.stalowy.ocrplapp.ocr_api.impl;

import com.asprise.ocr.Ocr;
import com.stalowy.ocrplapp.ocr_api.AspriseOcrApi;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.xml.ws.ServiceMode;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@Service
public class AspriseOcrApiImpl implements AspriseOcrApi {
    private static Logger logger = Logger.getLogger(Tess4jApiImpl.class.getName());

    @Override
    public String getOCRfromFile(MultipartFile multipartFile) {
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("pol", Ocr.SPEED_FAST);
        String result = ocr.recognize(new File[] {multipartToFile(multipartFile)},
                Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
        ocr.stopEngine();
        return result;
    }

    @Override
    public String getOCRfromUrl(String imageUrl){
        URL url;
        BufferedImage img = null;
        File file = new File("downloaded.jpg");
        try {
            url = new URL(imageUrl);
            img = ImageIO.read(url);
        } catch (IOException e) {
            logger.fatal("Unable to read image from URL", e);
        }
        try {
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            logger.fatal("unable to convert jpg to file");
        }
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
        String result = ocr.recognize(new File[] {file},
                Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
        ocr.stopEngine();
        return result;

    }

    private File multipartToFile(MultipartFile multipart) {
        File convFile = new File(multipart.getOriginalFilename());
        try {
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(multipart.getBytes());
            fos.close();
        } catch (IOException e) {
            logger.fatal("Unable to open file", e);
        }
        return convFile;
    }
}
