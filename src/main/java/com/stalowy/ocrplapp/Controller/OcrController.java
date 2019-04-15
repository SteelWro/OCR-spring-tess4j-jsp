package com.stalowy.ocrplapp.Controller;

import com.stalowy.ocrplapp.Model.FileResult;
import com.stalowy.ocrplapp.Model.UrlResult;
import com.stalowy.ocrplapp.Service.OcrFileService;
import com.stalowy.ocrplapp.Service.OcrUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OcrController {

    @Autowired
    OcrUrlService ocrUrlService;

    @Autowired
    OcrFileService ocrFileService;

    @RequestMapping("/")
    public String homeSite(Model model){
        UrlResult urlResult = new UrlResult();
        FileResult fileResult = new FileResult();
        model.addAttribute("urlResult", urlResult);
        model.addAttribute("fileResult", fileResult);
        return "index";
    }

    @PostMapping("/urlOCR")
    public String urlOcr(@ModelAttribute UrlResult urlResult, Model model){
        if(urlResult.getUrl()!=null) {
            urlResult.setResult(ocrUrlService.ocrFromLink(urlResult.getUrl()));
            model.addAttribute("urlResult", urlResult);
        }else System.out.println("brak url");
        return "urlResult";
    }

    @PostMapping("/fileOCR")
    public String handleFileUpload(@ModelAttribute FileResult fileResult, Model model) {
        fileResult.setResult(ocrFileService.ocrFromFile(fileResult.getMultipartFile()));

        model.addAttribute("fileResult", fileResult);
        return "fileResult";
    }




//    @GetMapping("/test")
//    public String doSomething(Model model){
//        model.addAttribute("datetime", new Date());
//        model.addAttribute("username", "Ömerrrr");
//
//        return "test";s
//    }
}
