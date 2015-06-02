package com.vspavlov.demoorm.domain.hibervalidator;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.service.MdbUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Created by vasiliy on 02.06.15.
 */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {

    @Autowired
    private MdbUserService mdbUserService;


    @Override
    public void initialize(UniqueEmail uniqueEmail) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null){
            return true;
        }

        Optional<MdbUser> mdbUser = mdbUserService.getUserByEmail(s);
        return  !(mdbUser.isPresent());

    }
}
