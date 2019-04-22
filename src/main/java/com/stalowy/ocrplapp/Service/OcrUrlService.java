package com.stalowy.ocrplapp.Service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class OcrUrlService {

//    @Value("${datapath}")
//    private String datapath;
    String Path = new File("").getAbsolutePath();

    public String ocrFromLink(String imageUrl){
        URL url = null;
        BufferedImage img = null;
        String result = null;
        try {
            url = new URL(imageUrl);
            img = ImageIO.read(url);
        } catch (MalformedURLException e) {
            System.out.println("błąd z linkiem");
        } catch (IOException e) {
            System.out.println("Obrazek z linku nie został odczytany");
        }

        ITesseract instance = new Tesseract();
        instance.setDatapath(Path+"/tessdata");
        instance.setLanguage("pol");

        try {
            return instance.doOCR(img);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return "blank";
    }

}
