package com.vspavlov.demoorm.validator;

import com.vspavlov.demoorm.dto.MdbUserCreateForm;
import com.vspavlov.demoorm.service.MdbUserService;
import com.vspavlov.demoorm.service.MdbUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Vasiliy on 25.05.2015.
 */
@Component
public class MdbUserCreateFormValidator implements Validator{


    @Autowired
    private MdbUserService mdbUserService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(MdbUserCreateForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MdbUserCreateForm mdf = (MdbUserCreateForm)o;
        validatePasswords(errors,mdf);
        validateEmail(errors,mdf);

    }

    private void validatePasswords(Errors errors, MdbUserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, MdbUserCreateForm form) {
        if (mdbUserService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }
}
