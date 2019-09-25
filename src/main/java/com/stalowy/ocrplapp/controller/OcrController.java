package com.stalowy.ocrplapp.controller;

import com.stalowy.ocrplapp.model.FileResult;
import com.stalowy.ocrplapp.model.UrlResult;
import com.stalowy.ocrplapp.service.impl.OcrFileServiceImpl;
import com.stalowy.ocrplapp.service.impl.OcrUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class OcrController {

    private OcrUrlServiceImpl ocrUrlService;
    private OcrFileServiceImpl ocrFileService;
    //private UrlResult urlResult;
    //private FileResult fileResult;

    @Autowired
    public OcrController(OcrUrlServiceImpl ocrUrlService, OcrFileServiceImpl ocrFileService) {
        this.ocrUrlService = ocrUrlService;
        this.ocrFileService = ocrFileService;
    }

    @GetMapping("/")
    public String homeSite(Model model) {
        if (!model.containsAttribute("fileResult")) {
            model.addAttribute("fileResult", new FileResult());
        }
        if (!model.containsAttribute("urlResult")) {
            model.addAttribute("urlResult", new UrlResult());
        }
        return "index";
    }

    @PostMapping("/urlOCR")
    public String urlOcr(@Valid @ModelAttribute("urlResult") UrlResult urlResult, final BindingResult bindingResult, Model model, RedirectAttributes attr, HttpSession session) {
        if (bindingResult.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.urlResult", bindingResult);
            attr.addFlashAttribute("urlResult", urlResult);
            return "redirect:/";
        }
        String result = ocrUrlService.ocrFromURL(urlResult.getUrl());
        urlResult.setResult(result);
        model.addAttribute("urlResult", urlResult);
        return "urlResult";
    }

    @PostMapping("/fileOCR")
    public String fileOCR(@Valid @ModelAttribute("fileResult") FileResult fileResult, final BindingResult bindingResult, Model model, RedirectAttributes attr, HttpSession session) {
        if (bindingResult.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.fileResult", bindingResult);
            attr.addFlashAttribute("fileResult", fileResult);
            return "redirect:/";
        }
        MultipartFile multipartFile = fileResult.getMultipartFile();
        String result = ocrFileService.ocrFromFile(multipartFile);
        fileResult.setResult(result);
        model.addAttribute("fileResult", fileResult);
        return "fileResult";
    }
}
