package com.vspavlov.demoorm.controller;

import com.vspavlov.demoorm.domain.users.MdbUser;
import com.vspavlov.demoorm.dto.MdbUserCreateForm;
import com.vspavlov.demoorm.registration.OnRegistrationCompleteEvent;
import com.vspavlov.demoorm.repository.VerificationTokenRepository;
import com.vspavlov.demoorm.service.MdbUserService;
import com.vspavlov.demoorm.service.MdbUserServiceImpl;
import com.vspavlov.demoorm.validator.MdbUserCreateFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by Vasiliy on 25.05.2015.
 */

@Controller
public class UserController implements ApplicationEventPublisherAware{

    private final Logger logger = LoggerFactory.getLogger(getClass());
  //  private final MdbUserCreateFormValidator mdbUserCreateFormValidator;
  //  private final MdbUserService mdbUserService;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private MdbUserService mdbUserService;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
         this.eventPublisher = applicationEventPublisher;
    }

//    @Autowired
//    public UserController(MdbUserCreateFormValidator mdbUserCreateFormValidator,MdbUserService mdbUserService) {
//        this.mdbUserCreateFormValidator = mdbUserCreateFormValidator;
//        this.mdbUserService = mdbUserService;
//    }


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
    public String handleMdbUserCreateForm(@Valid @ModelAttribute("registerForm") MdbUserCreateForm form,
                                          BindingResult bindingResult,
                                          HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "registerdev";
        }
        String appUrl = request.getContextPath();
         Locale locale = request.getLocale();
         MdbUser registered =  mdbUserService.create(form);
         eventPublisher.publishEvent(new OnRegistrationCompleteEvent(this,registered,locale,appUrl));

           return "redirect:/successregister";
    }



}
