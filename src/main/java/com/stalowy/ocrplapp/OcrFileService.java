package com.stalowy.ocrplapp;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class OcrFileService {

    @Value("${datapath}")
    private String datapath;

    public String ocrFromFile(File img){
            String result = null;

            ITesseract instance = new Tesseract();
            instance.setDatapath(datapath);
            instance.setLanguage("pol");

            try {
                return instance.doOCR(img);
            } catch (TesseractException e) {
                System.err.println(e.getMessage());
            }
            return "blank";
        }
}
