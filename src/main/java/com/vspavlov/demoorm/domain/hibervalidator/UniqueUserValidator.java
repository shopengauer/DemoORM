package com.vspavlov.demoorm.domain.hibervalidator;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.dto.MdbUserCreateForm;
import com.vspavlov.demoorm.service.MdbUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Created by vasiliy on 02.06.15.
 */
public class UniqueUserValidator implements ConstraintValidator<UniqueUser,String> {


    @Autowired
    private MdbUserService mdbUserService;

    @Override
    public void initialize(UniqueUser uniqueUser) {

    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {

        if(o == null){
            return true;
        }

        Optional<MdbUser> mdbUser = mdbUserService.getMdbUserByUsername(o);
        return  !(mdbUser.isPresent());
    }
}
