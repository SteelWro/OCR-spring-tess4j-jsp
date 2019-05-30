package com.stalowy.ocrplapp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface MultipartToFileService {
    File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException;
}
