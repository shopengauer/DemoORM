package com.vspavlov.demoorm.domain.hibervalidator;

import org.hibernate.validator.constraints.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vasiliy on 03.06.15.
 */
public class EmailValidator implements ConstraintValidator<Email,String> {

   private Pattern pattern;
   private Matcher matcher;
   private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+" +
            "(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*" +
            "(.[A-Za-z]{2,})$";

    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        return validateEmail(email);
    }

    private boolean validateEmail(String email){

        this.pattern = Pattern.compile(EMAIL_PATTERN);
        this.matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
