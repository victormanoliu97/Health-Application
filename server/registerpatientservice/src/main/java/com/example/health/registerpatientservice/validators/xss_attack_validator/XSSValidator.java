package com.example.health.registerpatientservice.validators.xss_attack_validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSValidator implements ConstraintValidator<XSSAnnotation, String> {

    private final String XSS_PATTERN = "<(|\\/|[^\\/>][^>]+|\\/[^>][^>]+)>";

    @Override
    public void initialize(XSSAnnotation xssAnnotation) {
        System.out.println("The XSS context");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(XSS_PATTERN);
        Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }
}
