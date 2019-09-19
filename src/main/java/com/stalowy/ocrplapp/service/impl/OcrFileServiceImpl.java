package com.stalowy.ocrplapp.service.impl;

import com.stalowy.ocrplapp.ocr_api.Tess4jApi;
import com.stalowy.ocrplapp.service.OcrFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OcrFileServiceImpl implements OcrFileService {

    Tess4jApi tess4jApi;

    @Autowired
    public OcrFileServiceImpl(Tess4jApi tess4jApi) {
        this.tess4jApi = tess4jApi;
    }

    @Override
    public String ocrFromFile(MultipartFile multipartFile) {
        return tess4jApi.getOCRfromFile(multipartFile);
    }

}
