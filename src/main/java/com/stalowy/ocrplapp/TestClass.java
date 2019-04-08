package com.stalowy.ocrplapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/ocr")
public class TestClass {

    private String appMode;

    @Autowired
    public TestClass(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @GetMapping("/test")
    public String doSomething(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        model.addAttribute("mode", appMode);

        return "test";
    }
}
