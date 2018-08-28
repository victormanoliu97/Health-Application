package com.example.health.registerpatientservice.validators.cnp_validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CNPValidator implements ConstraintValidator<CNPAnnotation, String> {

    private static final String CNP_PATTERN = "^[1-9]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)(00[1-9]|0[1-9]\\d|[1-9]\\d\\d)\\d$";

    @Override
    public void initialize(CNPAnnotation cnpAnnotation) {
        System.out.println("The CNP context");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(CNP_PATTERN);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
