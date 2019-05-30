package com.stalowy.ocrplapp.service;

import org.springframework.web.multipart.MultipartFile;

public interface OcrFileService {
    String ocrFromFile(MultipartFile file);
}
