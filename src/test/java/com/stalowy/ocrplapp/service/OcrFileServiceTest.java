package com.stalowy.ocrplapp.service;

import com.stalowy.ocrplapp.service.impl.OcrFileServiceImpl;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OcrFileServiceTest {

    MultipartFile multipartFile;
    File file;
    FileInputStream input;

    @Autowired
    OcrFileServiceImpl ocrFileService;

    @Before
    public void setUp() throws IOException {
        file = new File("src/main/resources/test_files/testing_image.jpg");
        input = new FileInputStream(file);
        multipartFile = new MockMultipartFile(
                "fileItem", file.getName(),
                "image/jpg",
                IOUtils.toByteArray(input));
    }

    @Test
    public void test() {

        String quotation = ocrFileService.ocrFromFile(multipartFile);

        String expected = "Najlepszy czas na działanie Jest teraz!\nMark Fisher\n";

        assertEquals(quotation, expected);
    }


}
