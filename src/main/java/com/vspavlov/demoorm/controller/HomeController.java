package com.vspavlov.demoorm.controller;

import com.vspavlov.demoorm.domain.Series;
import com.vspavlov.demoorm.domain.TechObjectType;
import com.vspavlov.demoorm.repository.SeriesRepository;
import com.vspavlov.demoorm.repository.TechObjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Vasiliy on 28.04.2015.
 */
@Controller
public class HomeController{


    @Autowired
    private TechObjectTypeRepository jpaTechObjectTypeRepository;

    @Autowired
   // @Qualifier(value = "series")
    private SeriesRepository seriesRepository;


    @RequestMapping(value = "/")
    public String home(Model model){
       List<TechObjectType> techObjectTypes = jpaTechObjectTypeRepository.findAll();
       List<Series> series = seriesRepository.findAll();

        model.addAttribute("tech",techObjectTypes);
        model.addAttribute("series",series);
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



}
