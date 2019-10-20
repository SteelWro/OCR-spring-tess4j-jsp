package com.stalowy.ocrplapp.config;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class TesseractConfig {
    private final String TESSDATA_PATH = "/usr/share/tesseract-ocr/tessdata/";
    private final String POL = "pol";

    @Bean
    public ITesseract iTesseract() {
        ITesseract instance = new Tesseract();
        instance.setDatapath(TESSDATA_PATH);
        instance.setLanguage(POL);
        return instance;
    }
}
