package com.fiipractic.health.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Victor Manoliu on 02-May-18
 */
public class EmailValidator implements ConstraintValidator<EmailAnnotation, String> {


    public boolean isValid(String stringi, ConstraintValidatorContext constraintValidatorContext) {
        return stringi.contains("@|.com");
    }

    @Override
    public void initialize(EmailAnnotation constraintAnnotation) {
        System.out.println("We create some context here");
    }

}
