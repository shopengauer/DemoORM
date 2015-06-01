package com.vspavlov.demoorm.domain.hibervalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Vasiliy on 26.05.2015.
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch,Object>{

    private String firstField;
    private String secondField;


    @Override
    public void initialize(FieldMatch fieldMatch) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
