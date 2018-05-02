package com.fiipractic.health.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Victor Manoliu on 02-May-18
 */
public class PhoneNumberValidator implements ConstraintValidator<EmailAnnotation, String> {

    @Override
    public void initialize(EmailAnnotation constraintAnnotation) {
        System.out.println("We create some context here");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("^(?:(?:\\\\+?1\\\\s*(?:[.-]\\\\s*)?)?(?:\\\\(\\\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\\\s*\\\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\\\s*(?:[.-]\\\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\\\s*(?:[.-]\\\\s*)?([0-9]{4})(?:\\\\s*(?:#|x\\\\.?|ext\\\\.?|extension)\\\\s*(\\\\d+))?$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
