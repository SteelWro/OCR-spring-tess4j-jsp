package com.stalowy.ocrplapp.validator;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileFormatValidator implements ConstraintValidator<FileFormatConstraint, Object> {
    private static Logger logger = Logger.getLogger(FileFormatValidator.class.getName());

    private static final String PNG_MIME_TYPE="image/png";
    private static final long TWENTY_MB_IN_BYTES = 20971520;

    @Override
    public void initialize(FileFormatConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object multipartFile, ConstraintValidatorContext constraintValidatorContext) {

        MultipartFile file = (MultipartFile)multipartFile;

        if(file.isEmpty()){
            logger.fatal("Uploaded file is empty");
            return false;
        }

        else if(!PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType())){
            logger.fatal("Invalid Format type of uploaded file");
            return false;
        }

        else if(file.getSize() > TWENTY_MB_IN_BYTES){
            logger.fatal("Size of file is exceeds 20 MB");
            return false;
        }
        return true;
    }
}
