package com.stalowy.ocrplapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileFormatValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileFormatConstraint {
    String message() default "plik przekracza 20 MB lub format jest nieprawidłowy";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
