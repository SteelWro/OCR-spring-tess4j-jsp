package com.stalowy.ocrplapp.validator;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileFormatValidator implements ConstraintValidator<FileFormatConstraint, Object> {
    private static Logger logger = Logger.getLogger(FileFormatValidator.class.getName());
    public static final String PNG_MIME_TYPE = "image/png";
    public static final String JPEG_MIME_TYPE = "image/jpeg";
    public static final String PDF_MIME_TYPE = "application/pdf";
    public static final String TTF_MIME_TYPE = "font/ttf";
    private static final long TWENTY_MB_IN_BYTES = 20971520;

    @Override
    public void initialize(FileFormatConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object multipartFile, ConstraintValidatorContext constraintValidatorContext) {

        MultipartFile file = (MultipartFile) multipartFile;

        if (file.isEmpty()) {
            logger.fatal("Uploaded file is empty");
            return false;
        } else if (!(PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType()) ||
                JPEG_MIME_TYPE.equalsIgnoreCase(file.getContentType()) ||
                PDF_MIME_TYPE.equalsIgnoreCase(file.getContentType()) ||
                PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType()) ||
                TTF_MIME_TYPE.equalsIgnoreCase(file.getContentType()))
        ) {
            logger.fatal("Invalid Format type of uploaded file");
            return false;
        } else if (file.getSize() > TWENTY_MB_IN_BYTES) {
            logger.fatal("Size of file is exceeds 20 MB");
            return false;
        }
        return true;
    }
}
