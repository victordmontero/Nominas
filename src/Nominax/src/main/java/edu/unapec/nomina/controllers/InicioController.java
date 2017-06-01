package edu.unapec.nomina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.unapec.nomina.modelos.Persona;

@Controller
public class InicioController {

	@RequestMapping(value = "/")
	public String Inicio(Model model) {

		model.addAttribute("titulo", "Titulo");
		model.addAttribute("mensaje", "Mensaje");

		return "index";
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.GET)
	public String Guardar() {

		return "guardar";
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String Guardar(Model model, Persona persona) {

		model.addAttribute("titulo", persona.toString());
		model.addAttribute("mensaje", persona.getEdad());

		return "index";
	}

}
