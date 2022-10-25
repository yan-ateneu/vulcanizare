package com.example.vulcanizare.controllers;

import com.example.vulcanizare.domain.Angajat;
import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.Reparatie;
import com.example.vulcanizare.domain.Vehicul;
import com.example.vulcanizare.services.AngajatService;
import com.example.vulcanizare.services.ReparatieService;
import com.example.vulcanizare.services.VehiculService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VehiculController {
    @Autowired
    public VehiculService vehiculService;
    @Autowired
    ReparatieService reparatieService;
    @Autowired
    AngajatService angajatService;

    public VehiculController(VehiculService vehiculService) {
        this.vehiculService = vehiculService;
    }
    @RequestMapping("/vehicul/list/{id_client}")
    public ModelAndView clientList(@PathVariable String id_client){
        ModelAndView modelAndView=new ModelAndView("vehicule");
        List<Vehicul> vehicule = vehiculService.findByClientiId(Long.valueOf(id_client));
        modelAndView.addObject("vehicule",vehicule);
        return modelAndView;

    }
    @RequestMapping("/vehicul/new/{id_client}")
    public String newVehicul(Model model,@PathVariable String id_client) {
        model.addAttribute("vehicul", new Vehicul());
        model.addAttribute("id_client",id_client);

        List<Reparatie> reparatiiAll = reparatieService.findAll();
        model.addAttribute("reparatiiAll", reparatiiAll );

        List<Angajat> angajatiAll = angajatService.findAll();
        model.addAttribute("angajatiAll", angajatiAll );

        return "vehiculform";
    }
    @PostMapping("/vehicul")
    public String saveOrUpdate(@RequestParam(name = "id_client") String id_client,
                               @ModelAttribute("vehicul") Vehicul vehicul,
                               @ModelAttribute ArrayList<Reparatie> reparatiiAll, @ModelAttribute ArrayList<Angajat> angajatiAll){
    Vehicul savedVehicul = vehiculService.save(vehicul);
    return "redirect:/vehicul/list/{id_client}";
}
    @RequestMapping("/vehicul/delete/{id}")
    public String deleteById(@PathVariable String id){
        vehiculService.deleteById(Long.valueOf(id));
        return "redirect:/vehicul/list";
    }
    @RequestMapping("/vehicul/update/{id}")
    public String updateClient(@PathVariable String id, Model model) {
        model.addAttribute("vehicul",
                vehiculService.findById(Long.valueOf(id)));
        return "vehiculform";
    }
}
