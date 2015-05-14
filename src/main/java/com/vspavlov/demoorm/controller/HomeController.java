package com.vspavlov.demoorm.controller;

import com.vspavlov.demoorm.domain.Series;
import com.vspavlov.demoorm.domain.TechObjectType;
import com.vspavlov.demoorm.forms.LoginForm;
import com.vspavlov.demoorm.repository.SeriesRepository;
import com.vspavlov.demoorm.repository.TechObjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Vasiliy on 28.04.2015.
 */
@Controller
@SessionAttributes(value = "user",types = LoginForm.class)
public class HomeController{


    @Autowired
    private TechObjectTypeRepository jpaTechObjectTypeRepository;

    @Autowired
   // @Qualifier(value = "series")
    private SeriesRepository seriesRepository;


    @ModelAttribute
    public void populateAttribute(Model model){
        System.out.println("Inside of populateAttribute");
        List<Series> series = seriesRepository.findAll();
        model.addAttribute("series",series);
        model.addAttribute("userForm",new LoginForm("Wasiliy"));
    }

    @RequestMapping(value = "/")
    public String home(Model model){
       List<TechObjectType> techObjectTypes = jpaTechObjectTypeRepository.findAll();
       model.addAttribute("tech",techObjectTypes);

       return "home";
    }

    @RequestMapping(value = "/index")
    public String index(Model model){
        List<TechObjectType> techObjectTypes = jpaTechObjectTypeRepository.findAll();
        List<Series> series = seriesRepository.findAll();

        model.addAttribute("tech",techObjectTypes);
        model.addAttribute("series",series);
        return "index";
    }

    @RequestMapping(value = "/body",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public TechObjectType body(ModelAndView model){
        //model.
        TechObjectType techObjectType = new TechObjectType();
        techObjectType.setId(10);
        techObjectType.setNametype("Type");
        return techObjectType;
    }
    @RequestMapping(value = "/body2",produces = "application/json",method = RequestMethod.GET)
    @ResponseBody
    public String body(Model model){
        //model.

        return "Модная фишка";
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String mylog(Model model){
        return "login";
    }


//    @RequestMapping(value = "/logout",method = RequestMethod.GET)
//    public String mylogout(Model model){
//        return "home";
//    }


}
