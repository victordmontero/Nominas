/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Puestos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Phenom
 */
@Controller
@RequestMapping(value = "/puestos")
public class PuestoController extends CRUDController<Puestos> {

    public PuestoController(IRepositorio<Puestos> repositorio) {
        super(repositorio);
    }
    
    @RequestMapping(value = "/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("puestos",repositorio.ObtenerTodos());
        mv.setViewName("puestos/listar");
        return mv;
    }

    @RequestMapping(value = "/guardar")
    public ModelAndView guardar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("puesto",new Puestos());
        String[] riesgos = {"Alto","Medio","Bajo"};
        mv.addObject("riesgos",riesgos);
        mv.setViewName("puestos/guardar");
        return mv;
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ModelAndView guardar(Puestos puesto) {
        ModelAndView mv = new ModelAndView();
        repositorio.Guardar(puesto);
        mv.setViewName("redirect:listar");
        return mv;
    }
    
    @RequestMapping(value = "/editar/{idPuesto}", method = RequestMethod.GET)
    public ModelAndView editar(@PathVariable int idPuesto) {
        ModelAndView mv = new ModelAndView();
        Puestos puesto = repositorio.ObtenerUno(idPuesto);
        mv.addObject("puesto",puesto);
        mv.setViewName("puestos/editar");
        return mv;
    }
}
