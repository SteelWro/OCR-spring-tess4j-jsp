package com.stalowy.ocrplapp.service.impl;

import com.stalowy.ocrplapp.ocr_api.Tess4jApi;
import com.stalowy.ocrplapp.service.OcrUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcrUrlServiceImpl implements OcrUrlService {

    Tess4jApi tess4jApi;

    @Autowired
    public OcrUrlServiceImpl(Tess4jApi tess4jApi) {
        this.tess4jApi = tess4jApi;
    }

    @Override
    public String ocrFromURL(String imageUrl) {
        return tess4jApi.getOCRfromUrl(imageUrl);
    }

}