package edu.unapec.nomina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

    @RequestMapping(value = "/")
    public String Inicio(Model model) {
        model.addAttribute("titulo", "Index");
        model.addAttribute("mensaje", "Mensaje");
        
        return "index";
    }
}
