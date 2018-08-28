package com.example.health.registerpatientservice.validators.sql_injection_validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLInjectionValidator implements ConstraintValidator<SQLInjectionAnnotation, String> {

    private static final String SQLINJ_PATTERN = "('(''|[^'])*')|(;)|(\b(ALTER|CREATE|DELETE|DROP|EXEC(UTE){0,1}|INSERT( +INTO){0,1}|MERGE|SELECT|UPDATE|UNION( +ALL){0,1})\b)  ";

    @Override
    public void initialize(SQLInjectionAnnotation sqlInjectionAnnotation) {
        System.out.println("The SQL context");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(SQLINJ_PATTERN);
        Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }
}
