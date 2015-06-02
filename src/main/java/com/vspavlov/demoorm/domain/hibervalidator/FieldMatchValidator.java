package com.vspavlov.demoorm.domain.hibervalidator;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Vasiliy on 26.05.2015.
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch,Object>{

    private String firstField;
    private String secondField;
    private String errorMessage;

    @Override
    public void initialize(FieldMatch fieldMatch) {
       this.firstField = fieldMatch.firstValue();
       this.secondField = fieldMatch.secondValue();
       this.errorMessage = fieldMatch.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        boolean toReturn = false;

        try {
            final String firstObj = BeanUtils.getProperty(o, firstField);
            final String secondObj = BeanUtils.getProperty(o, secondField);
          //  toReturn = firstObj == null && secondObj == null || firstObj != null && secondObj.equals(secondObj);
               toReturn = firstObj.equals(secondObj);

        }  catch (final Exception e){
            System.out.println(e.toString());
        }
        //If the validation failed
        if(!toReturn) {
         constraintValidatorContext.disableDefaultConstraintViolation();
        //In the initialiaze method you get the errorMessage: constraintAnnotation.message();
         constraintValidatorContext.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(firstField).addConstraintViolation();

        }
        return toReturn;
    }
}
