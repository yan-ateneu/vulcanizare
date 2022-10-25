package com.example.vulcanizare.controllers;

import com.example.vulcanizare.domain.Client;
import com.example.vulcanizare.domain.DetaliiClient;
import com.example.vulcanizare.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @RequestMapping("/client/list")
    public ModelAndView clientList(){
        ModelAndView modelAndView=new ModelAndView("clienti");
        List<Client> clienti = clientService.findAll();
        modelAndView.addObject("clienti",clienti);

        return modelAndView;
    }
    @RequestMapping("/client/new")
    public String newClient(Model model) {
        model.addAttribute("client", new Client());
        return "clientform";
    }
    @PostMapping("/client")
    public String saveOrUpdate(@ModelAttribute Client client){
        Client savedClient = clientService.save(client);
        return "redirect:/client/list/";
    }
    @RequestMapping("/client/delete/{id}")
    public String deleteById(@PathVariable String id){
        clientService.deleteById(Long.valueOf(id));
        return "redirect:/client/list";
    }
    @RequestMapping("/client/update/{id}")
    public String updateClient(@PathVariable String id, Model model) {
        model.addAttribute("client",
                clientService.findById(Long.valueOf(id)));
        return "clientform";
    }
    @GetMapping("/client/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("client",
                clientService.findById(Long.valueOf(id)));
        return "infoclient";
    }
    @RequestMapping("/client/info/new")
    public String newDetaliiClient(Model model) {
        model.addAttribute("detalii client", new DetaliiClient());
        return "detaliiclientform";
    }
}
