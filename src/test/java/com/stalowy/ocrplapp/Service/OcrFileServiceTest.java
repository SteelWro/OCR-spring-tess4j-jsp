package com.stalowy.ocrplapp.Service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OcrFileServiceTest {

    URL url;
    BufferedImage img;
    ByteArrayOutputStream baos;
    MultipartFile multipartFile;

    @Autowired
    OcrFileService ocrFileService;

    @Before
    public void setUp(){
        try {
            url = new URL("https://image.slidesharecdn.com/24-motywujce-cytaty-dla-kadego-29884/95/24-motywujce-cytaty-dla-kadego-13-728.jpg?cb=1180699047");
            img = ImageIO.read(url);
            baos = new ByteArrayOutputStream();
            ImageIO.write( img, "jpg", baos );
            multipartFile = new MultipartImage(baos.toByteArray(),"image.jpg", "original.jpg",  MediaType.MULTIPART_FORM_DATA.toString(), baos.size());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        String quotation = ocrFileService.ocrFromFile(multipartFile);

        String expected = "Najlepszy czas na działanie Jest teraz!\nMark Fisher\n";

        assertEquals(quotation,expected);
    }



}
