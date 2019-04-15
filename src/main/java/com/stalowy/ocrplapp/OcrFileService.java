package com.stalowy.ocrplapp;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class OcrFileService {

    @Value("${datapath}")
    private String datapath;

    public String ocrFromFile(MultipartFile file){
        if(file==null) throw new IllegalArgumentException();
            String result = null;

            ITesseract instance = new Tesseract();
            instance.setDatapath(datapath);
            instance.setLanguage("pol");

            try {
                return instance.doOCR(multipartToFile(file));
            } catch (TesseractException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "blank";
        }

    public static File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File(multipart.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipart.getBytes());
        fos.close();
        return convFile;
    }
}
