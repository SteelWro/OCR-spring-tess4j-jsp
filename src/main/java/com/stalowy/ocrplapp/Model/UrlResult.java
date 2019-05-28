package com.stalowy.ocrplapp.Model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UrlResult {

    @NotNull
    @Size(min=5, max=400, message = "Coś nie tak z tym linkiem")
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

    @Override
    public String toString() {
        return "UrlResult{" +
                "url='" + url + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
