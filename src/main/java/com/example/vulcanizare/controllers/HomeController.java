package com.example.vulcanizare.controllers;
import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ClientService clientService;

    @GetMapping("/showLogInForm")
    public String showLogInForm(){ return "login"; }

    @RequestMapping({"", "/", "/index"})
    public ModelAndView productsList(){
        ModelAndView modelAndView = new ModelAndView("clienti");
        List<Client> clienti = clientService.findAll();
        modelAndView.addObject("clienti",clienti);
        return modelAndView;
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }

}
