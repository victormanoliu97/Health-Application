package com.example.health.registerpatientservice.validators.xss_attack_validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy = {XSSValidator.class})
public @interface XSSAnnotation {

    String message() default "Endpoint user has tried to xss attack";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
