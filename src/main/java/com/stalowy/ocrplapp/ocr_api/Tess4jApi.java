package com.stalowy.ocrplapp.ocr_api;

import org.springframework.web.multipart.MultipartFile;

public interface Tess4jApi {

    String getOCRfromFile(MultipartFile multipartFile);
    String getOCRfromUrl(String imageUrl);
}
