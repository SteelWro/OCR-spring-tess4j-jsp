package com.stalowy.ocrplapp.service.impl;

import com.stalowy.ocrplapp.service.OcrUrlService;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class OcrUrlServiceImpl implements OcrUrlService {

    @Autowired
    ITesseract iTesseract;

    @Override
    public String ocrFromURL(String imageUrl) {
        URL url = null;
        BufferedImage img = null;
        String result = null;

        try {
            url = new URL(imageUrl);
            img = ImageIO.read(url);
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {
            result = iTesseract.doOCR(img);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

}
