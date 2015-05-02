package com.vspavlov.demoorm.controller;

import com.vspavlov.demoorm.domain.Series;
import com.vspavlov.demoorm.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by Василий on 01.05.2015.
 */
@Controller
@RequestMapping(value = "/session")
@SessionAttributes(value = "sessionUser")
public class SessionController {




    @ModelAttribute
    public void modelPopulateAttribute(Model model){
        System.out.println("Inside of modelPopulateAttribute");
        model.addAttribute("user", new String("Wasiliy"));
        model.addAttribute("sessionUser",new String("Session Wasiliy"));
    }

    @RequestMapping(value = "/my")
    public String doSomthing(Model model, HttpServletRequest httpServletRequest,HttpSession session){

        System.out.println("Inside of doSomthingMethod");


        System.out.println("--- Model data ---");
        Map modelMap = model.asMap();
        for (Object modelKey : modelMap.keySet()) {
            Object modelValue = modelMap.get(modelKey);
            System.out.println(modelKey + "  " + modelValue);
        }

        System.out.println("=== Request data ===");
        Enumeration<String> reqEnum = httpServletRequest.getAttributeNames();
        while(reqEnum.hasMoreElements()){
           String s = reqEnum.nextElement();
            System.out.println(s);
            System.out.println("==" + httpServletRequest.getAttribute(s));

        }

        System.out.println("********* Session  *************");
        Enumeration<String> sessionEnum = session.getAttributeNames();

        while (sessionEnum.hasMoreElements()) {
            String s =  sessionEnum.nextElement();
            System.out.println(s);
            System.out.println("***" + session.getAttribute(s));
        }


        return "mdb/main";
    }


    @RequestMapping(value = "/your")
    public String status(SessionStatus status){
        System.out.println(status.isComplete());
        return "index";

    }

}
