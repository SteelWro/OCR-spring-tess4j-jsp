package com.stalowy.ocrplapp.Model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

public class FileResult {

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
