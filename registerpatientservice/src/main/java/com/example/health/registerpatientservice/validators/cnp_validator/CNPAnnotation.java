package com.example.health.registerpatientservice.validators.cnp_validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {CNPValidator.class})
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface CNPAnnotation {

    String message() default "The CNP format is not correct";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
