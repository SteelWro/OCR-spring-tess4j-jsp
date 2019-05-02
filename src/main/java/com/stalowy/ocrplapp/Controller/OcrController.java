package com.stalowy.ocrplapp.Controller;

import com.stalowy.ocrplapp.Model.FileResult;
import com.stalowy.ocrplapp.Model.UrlResult;
import com.stalowy.ocrplapp.Service.OcrFileService;
import com.stalowy.ocrplapp.Service.OcrUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class OcrController {

    @Autowired
    OcrUrlService ocrUrlService;

    @Autowired
    OcrFileService ocrFileService;

    @RequestMapping("/")
    public String homeSite(Model model) {
        UrlResult urlResult = new UrlResult();
        FileResult fileResult = new FileResult();
        model.addAttribute("urlResult", urlResult);
        model.addAttribute("fileResult", fileResult);
        return "index";
    }

    @PostMapping("/urlOCR")
    public String urlOcr(@ModelAttribute UrlResult urlResult, Model model) {
        if (urlResult.getUrl() != null) {
            String result = ocrUrlService.ocrFromLink(urlResult.getUrl());
            urlResult.setResult(result);
            model.addAttribute("urlResult", urlResult);
        } else System.out.println("brak url");
        return "urlResult";
    }

    @PostMapping("/fileOCR")
    public String handleFileUpload(@ModelAttribute FileResult fileResult, Model model) {
        MultipartFile multipartFile = fileResult.getMultipartFile();
        String result = ocrFileService.ocrFromFile(multipartFile);
        fileResult.setResult(result);
        model.addAttribute("fileResult", fileResult);
        return "fileResult";
    }
}
