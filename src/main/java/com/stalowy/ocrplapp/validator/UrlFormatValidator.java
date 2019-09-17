package com.stalowy.ocrplapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlFormatValidator implements ConstraintValidator<UrlFormatConstraint, String> {
    private final String REGEX = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    @Override
    public void initialize(UrlFormatConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {

        HttpURLConnection huc = null;
        int responseCode;
        try {
            huc = (HttpURLConnection) new URL(url).openConnection();
            huc.setRequestMethod("HEAD");
            responseCode = huc.getResponseCode();
        } catch (IOException e) {
            return false;
        }

        return (IsMatch(url, REGEX) && responseCode != HttpURLConnection.HTTP_NOT_FOUND);
    }

    private boolean IsMatch(String url, String pattern) {
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(url);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }
}
