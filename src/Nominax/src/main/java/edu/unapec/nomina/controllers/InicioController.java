package edu.unapec.nomina.controllers;

import edu.unapec.nomina.modelos.Puestos;
import edu.unapec.nomina.*;
import edu.unapec.nomina.dao.IRepositorio;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

    IRepositorio<Puestos> repo;

    public InicioController(IRepositorio<Puestos> repo) {
        this.repo = repo;
    }
    
    @RequestMapping(value = "/")
    public String Inicio(Model model) {
        model.addAttribute("titulo", "Index");
        model.addAttribute("mensaje", "Mensaje");
        
        return "index";
    }

    //<editor-fold defaultstate="collapsed" desc="Comentado">
    /*
        
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
        
     */
    //</editor-fold>
}
