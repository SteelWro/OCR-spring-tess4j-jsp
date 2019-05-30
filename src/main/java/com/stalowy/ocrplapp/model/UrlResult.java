package com.stalowy.ocrplapp.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UrlResult {

    private final String ERROR = "Link jest niepoprawny";

    @NotNull
    @Size(min=5, max=400, message = ERROR) //
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
