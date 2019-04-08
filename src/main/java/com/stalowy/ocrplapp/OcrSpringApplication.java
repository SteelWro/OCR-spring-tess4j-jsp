package com.stalowy.ocrplapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OcrSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcrSpringApplication.class, args);
//        OcrLinkService ocr = new OcrLinkService();
//        System.out.println(ocr.ocrFromLink("https://ecowall24.pl/222-large_default/cytat-dom.jpg"));
  }


}
