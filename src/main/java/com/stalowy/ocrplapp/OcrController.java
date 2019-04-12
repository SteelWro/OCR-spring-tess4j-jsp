package com.stalowy.ocrplapp;

import com.stalowy.ocrplapp.OcrFileService;
import com.stalowy.ocrplapp.OcrUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String urlOcr(@ModelAttribute UrlResult urlResult, Model model){
        if(urlResult.getUrl()!=null) {
            urlResult.setResult(ocrUrlService.ocrFromLink(urlResult.getUrl()));
            model.addAttribute("urlResult", urlResult);
        }else System.out.println("brak url");
        return "ocrResult";
    }

    @PostMapping("/fileOCR")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        String resultString = ocrFileService.ocrFromFile(file);
        model.addAttribute("urlResult", resultString);
        return "ocrResult";
    }




//    @GetMapping("/test")
//    public String doSomething(Model model){
//        model.addAttribute("datetime", new Date());
//        model.addAttribute("username", "Ömerrrr");
//
//        return "test";s
//    }
}
