package com.stalowy.ocrplapp.ocr_api.impl;

import com.stalowy.ocrplapp.ocr_api.Tess4jApi;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@Service
public class Tess4jApiImpl implements Tess4jApi {

    private static Logger logger = Logger.getLogger(Tess4jApiImpl.class.getName());
    private ITesseract iTesseract;

    @Autowired
    public Tess4jApiImpl(ITesseract iTesseract) {
        this.iTesseract = iTesseract;
    }

    @Override
    public String getOCRfromFile(MultipartFile multipartFile) {
        String result = null;
        try {
            result = iTesseract.doOCR(multipartToFile(multipartFile));
        } catch (TesseractException e) {
            logger.fatal("Unable to use doOCR method", e);
        }
        return result;
    }

    @Override
    public String getOCRfromUrl(String imageUrl) {
        URL url;
        BufferedImage img = null;
        String result = null;

        try {
            url = new URL(imageUrl);
            img = ImageIO.read(url);
        } catch (IOException e) {
        logger.fatal("Unable to read image from URL", e);
    }

        try {
            result = iTesseract.doOCR(img);
        } catch (TesseractException e) {
            logger.fatal("Unable to use doOCR method", e);
        }
        return result;
    }

    private File multipartToFile(MultipartFile multipart) {
        File convFile = new File(multipart.getOriginalFilename());
        try {
            //convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(multipart.getBytes());
            fos.close();
        } catch (IOException e) {
            logger.fatal("Unable to open file", e);
        }
        return convFile;
    }
}
