package com.stalowy.ocrplapp.service.impl;

import com.stalowy.ocrplapp.service.MultipartToFileService;
import com.stalowy.ocrplapp.service.OcrUrlService;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Service
public class OcrUrlServiceImpl implements OcrUrlService {

    private static Logger logger = Logger.getLogger(MultipartToFileService.class.getName());
    private ITesseract iTesseract;

    @Autowired
    public OcrUrlServiceImpl(ITesseract iTesseract) {
        this.iTesseract = iTesseract;
    }

    @Override
    public String ocrFromURL(String imageUrl) {
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
            logger.fatal("Unable to use url OCR method", e);
        }

        return result;
    }

}
