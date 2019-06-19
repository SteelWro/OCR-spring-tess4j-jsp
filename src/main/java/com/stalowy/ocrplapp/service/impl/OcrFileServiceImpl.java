package com.stalowy.ocrplapp.service.impl;

import com.stalowy.ocrplapp.service.MultipartToFileService;
import com.stalowy.ocrplapp.service.OcrFileService;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OcrFileServiceImpl implements OcrFileService {

    static Logger logger = Logger.getLogger(MultipartToFileService.class.getName());
    ITesseract iTesseract;
    MultipartToFileServiceImpl multipartToFile;

    @Autowired
    public OcrFileServiceImpl(ITesseract iTesseract, MultipartToFileServiceImpl multipartToFile) {
        this.iTesseract = iTesseract;
        this.multipartToFile = multipartToFile;
    }

    @Override
    public String ocrFromFile(MultipartFile file) {
        String result = null;
        try {
            result = iTesseract.doOCR(multipartToFile.multipartToFile(file));
        } catch (TesseractException e) {
            logger.fatal("Unable to use doOCR method", e);
        }
        return result;
    }

}
