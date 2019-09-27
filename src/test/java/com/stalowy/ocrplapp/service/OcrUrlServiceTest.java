//package com.stalowy.ocrplapp.service;
//
//import com.stalowy.ocrplapp.service.impl.OcrUrlServiceImpl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class OcrUrlServiceTest {
//
//    @Autowired
//    OcrUrlServiceImpl ocrUrlService;
//
//    @Test
//    public void test() {
//        String quotation = ocrUrlService.ocrFromURL("https://image.slidesharecdn.com/24-motywujce-cytaty-dla-kadego-29884/95/24-motywujce-cytaty-dla-kadego-13-728.jpg?cb=1180699047");
//
//        String expected = "Najlepszy czas na działanie jest teraz!\nMark Fisher\n";
//
//        assertEquals(quotation, expected);
//    }
//}
