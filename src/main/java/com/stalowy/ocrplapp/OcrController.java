package com.stalowy.ocrplapp;

import com.stalowy.ocrplapp.OcrFileService;
import com.stalowy.ocrplapp.OcrUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class OcrController {

    @Autowired
    OcrUrlService ocrUrlService;

    @Autowired
    OcrFileService ocrFileService;

    @RequestMapping("/")
    public String homeSite(Model model){
        UrlResult urlResult = new UrlResult();
        model.addAttribute("urlResult", urlResult);
        return "index";
    }

    @PostMapping("/urlOCR")
    public String urlOcr(@RequestAttribute UrlResult urlResult, Model model){
        System.out.println(urlResult.getUrl());
        System.out.println(urlResult.getResult());
//        if(urlResult.getUrl()!=null) {
//            urlResult.setResult(ocrUrlService.ocrFromLink(urlResult.getUrl()));
//            model.addAttribute("urlResult", urlResult);
//        }else System.out.println("brak url");

        return "index";
    }




//    @GetMapping("/test")
//    public String doSomething(Model model){
//        model.addAttribute("datetime", new Date());
//        model.addAttribute("username", "Ömerrrr");
//
//        return "test";
//    }
}
