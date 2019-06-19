package com.stalowy.ocrplapp.service.impl;

import com.stalowy.ocrplapp.service.MultipartToFileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class MultipartToFileServiceImpl implements MultipartToFileService {

    static Logger logger = Logger.getLogger(MultipartToFileService.class.getName());

    @Override
    public File multipartToFile(MultipartFile multipart) {
        File convFile = new File(multipart.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(multipart.getBytes());
            fos.close();
        } catch (IOException e) {
            logger.fatal("Unable to open file", e);
        }
        return convFile;
    }

}
