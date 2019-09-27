package com.stalowy.ocrplapp;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OcrSpringApplication {

    public static void main(String[] args) {
        System.setProperty("jna.library.path", "32".equals(System.getProperty("sun.arch.data.model")) ? "lib/x86" : "lib/x64");
        SpringApplication.run(OcrSpringApplication.class, args);
        BasicConfigurator.configure();
  }


}
