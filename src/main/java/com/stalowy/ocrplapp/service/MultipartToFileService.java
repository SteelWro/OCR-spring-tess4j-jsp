package com.stalowy.ocrplapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class MultipartToFileService {
    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        if (multipart == null) {
            throw new IllegalArgumentException();
        }
        File convFile = new File(multipart.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipart.getBytes());
        fos.close();
        return convFile;
    }
}
