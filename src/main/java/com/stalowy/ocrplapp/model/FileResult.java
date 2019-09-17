package com.stalowy.ocrplapp.model;

import com.stalowy.ocrplapp.validator.FileFormatConstraint;
import org.springframework.web.multipart.MultipartFile;

public class FileResult {

    @FileFormatConstraint
    private MultipartFile multipartFile;

    private String result;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
