package com.stalowy.ocrplapp.validator;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileFormatValidator implements ConstraintValidator<FileFormatConstraint, Object> {
    public static final String PNG_MIME_TYPE = "image/png";
    public static final long TEN_MB_IN_BYTES = 10485760*2;
    public static final String JPEG_MIME_TYPE = "image/jpeg";
    public static final String PDF_MIME_TYPE = "application/pdf";
    public static final String TTF_MIME_TYPE = "font/ttf";

    @Override
    public void initialize(FileFormatConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object multipartFile, ConstraintValidatorContext constraintValidatorContext) {

        MultipartFile file = (MultipartFile)multipartFile;
        if(file.isEmpty()){
            return false;
        }
        else if(!(PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType()) ||
                JPEG_MIME_TYPE.equalsIgnoreCase(file.getContentType()) ||
                PDF_MIME_TYPE.equalsIgnoreCase(file.getContentType()) ||
                PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType()))
        ){
            return false;
        }

        else if(file.getSize() > TEN_MB_IN_BYTES){
            return false;
        }
        return true;
    }
}
