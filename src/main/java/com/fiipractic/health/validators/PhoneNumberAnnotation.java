package com.fiipractic.health.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * @author Victor Manoliu on 02-May-18
 */
@Constraint(validatedBy = {EmailValidator.class})
@Target(value = {METHOD, FIELD, CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberAnnotation {

    String message() default "The phone number is not correct";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
