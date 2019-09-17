package com.stalowy.ocrplapp.model;


import com.stalowy.ocrplapp.validator.UrlFormatConstraint;


public class UrlResult {

    @UrlFormatConstraint
    private String url;

    private String result;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
