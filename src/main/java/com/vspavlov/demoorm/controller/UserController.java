package com.vspavlov.demoorm.controller;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.dto.MdbUserCreateForm;
import com.vspavlov.demoorm.service.MdbUserService;
import com.vspavlov.demoorm.service.MdbUserServiceImpl;
import com.vspavlov.demoorm.validator.MdbUserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Vasiliy on 25.05.2015.
 */

@Controller
public class UserController {


    private final MdbUserCreateFormValidator mdbUserCreateFormValidator;
    private final MdbUserService mdbUserService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserController(MdbUserCreateFormValidator mdbUserCreateFormValidator,MdbUserService mdbUserService) {
        this.mdbUserCreateFormValidator = mdbUserCreateFormValidator;
        this.mdbUserService = mdbUserService;
    }


//    @InitBinder("registerForm")
//    public void initBinder(WebDataBinder binder) {
//        binder.addValidators(mdbUserCreateFormValidator);
//    }



    @RequestMapping(value = "/logindev",method = RequestMethod.GET)
    public String mylogdev(Model model){
        return "logindev";
    }

    @RequestMapping(value = "/registerdev",method = RequestMethod.GET)
    public String getMdbUserRegisterPage(Model model){
        model.addAttribute("registerForm",new MdbUserCreateForm());
        return "registerdev";
    }

    @RequestMapping(value = "/registerdev",method = RequestMethod.POST)
    public String handleMdbUserCreateForm(@Valid @ModelAttribute("registerForm") MdbUserCreateForm form,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "registerdev";
        }

        mdbUserService.create(form);
           return "redirect:/successregister";
    }



}
