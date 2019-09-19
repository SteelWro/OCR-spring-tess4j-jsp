package com.stalowy.ocrplapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UrlFormatValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlFormatConstraint {
    String message() default "link jest nie prawidłowy lub nie istniejek";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
