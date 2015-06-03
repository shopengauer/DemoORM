package com.vspavlov.demoorm.domain.hibervalidator;

import com.vspavlov.demoorm.dto.MdbUserCreateForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vasiliy on 03.06.15.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,MdbUserCreateForm> {

    @Override
    public void initialize(PasswordMatches passwordMatches) {

    }

    @Override
    public boolean isValid(MdbUserCreateForm form, ConstraintValidatorContext constraintValidatorContext) {

        if(form == null){
            return true;
        }

        boolean isValid = form.getPassword().equals(form.getPasswordRepeated());

        if(!isValid){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{notmatch.passwords}").
                    addPropertyNode("password").addConstraintViolation();
        }


        return isValid;// form.getPassword().equals(form.getPasswordRepeated());
    }
}
