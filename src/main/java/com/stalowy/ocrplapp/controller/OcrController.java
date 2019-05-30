package com.stalowy.ocrplapp.controller;

import com.stalowy.ocrplapp.model.FileResult;
import com.stalowy.ocrplapp.model.UrlResult;
import com.stalowy.ocrplapp.service.impl.OcrFileServiceImpl;
import com.stalowy.ocrplapp.service.impl.OcrUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class OcrController {

    OcrUrlServiceImpl ocrUrlService;
    OcrFileServiceImpl ocrFileService;
    UrlResult urlResult;
    FileResult fileResult;

    @Autowired
    public OcrController(OcrUrlServiceImpl ocrUrlService, OcrFileServiceImpl ocrFileService) {
        this.ocrUrlService = ocrUrlService;
        this.ocrFileService = ocrFileService;
    }

    @RequestMapping("/")
    public String homeSite(Model model) {
        urlResult = new UrlResult();
        fileResult = new FileResult();
        model.addAttribute("urlResult", urlResult);
        model.addAttribute("fileResult", fileResult);
        return "index";
    }

    @PostMapping("/urlOCR")
    public String urlOcr(@Valid UrlResult urlResult, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("fileResult", fileResult);
            return "index";
        }
        String result = ocrUrlService.ocrFromURL(urlResult.getUrl());
        urlResult.setResult(result);
        model.addAttribute("urlResult", urlResult);
        return "urlResult";
    }

    @PostMapping("/fileOCR")
    public String fileOCR(@ModelAttribute("FileResult") FileResult fileResult, Model model) {
        MultipartFile multipartFile = fileResult.getMultipartFile();
        String result = ocrFileService.ocrFromFile(multipartFile);
        fileResult.setResult(result);
        model.addAttribute("fileResult", fileResult);
        return "fileResult";
    }
}
