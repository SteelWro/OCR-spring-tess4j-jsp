package com.stalowy.ocrplapp.service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class OcrFileService {

    ITesseract iTesseract;
    MultipartToFileService multipartToFile;

    @Autowired
    public OcrFileService(ITesseract iTesseract, MultipartToFileService multipartToFile) {
        this.iTesseract = iTesseract;
        this.multipartToFile = multipartToFile;
    }

    public String ocrFromFile(MultipartFile file) {
        String result = null;
        try {
            result = iTesseract.doOCR(multipartToFile.multipartToFile(file));
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

}
