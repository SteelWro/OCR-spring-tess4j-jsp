package com.stalowy.ocrplapp.config;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private final String WINDOWS_PATH = new File("").getAbsolutePath();
    private final String POL = "pol";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/static/img/**",
                "/css/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/");
    }

    @Bean
    public ITesseract iTesseract(){
        ITesseract instance = new Tesseract();
        instance.setDatapath(WINDOWS_PATH + "/tessdata");
        instance.setLanguage(POL);
        return instance;
    }


}
