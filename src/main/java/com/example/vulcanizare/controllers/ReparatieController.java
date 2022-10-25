package com.example.vulcanizare.controllers;

import com.example.vulcanizare.domain.Reparatie;
import com.example.vulcanizare.domain.Vehicul;
import com.example.vulcanizare.services.ReparatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class ReparatieController {
    @Autowired
    ReparatieService reparatieService;

    public ReparatieController(ReparatieService reparatieService) {
        this.reparatieService = reparatieService;
    }
        @RequestMapping("/reparatii/list")
    public ModelAndView productsList(){
        ModelAndView modelAndView=new ModelAndView("reparatii");
        List<Reparatie> reparatii = reparatieService.findAll();
        modelAndView.addObject("reparatii",reparatii);

        return modelAndView;
    }
    @RequestMapping("/reparatii/new")
    public String newReparatie(Model model) {
        model.addAttribute("reparatie", new Reparatie());
        List<Reparatie> categoriesAll = reparatieService.findAll();

        model.addAttribute("re", categoriesAll );
        return "productform";
    }
}
