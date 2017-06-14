/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Empleados;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phenom
 */
@Controller
@RequestMapping(value = "/empleados")
public class EmpleadoController extends CRUDController<Empleados>{

    public EmpleadoController(IRepositorio<Empleados> repositorio) {
        super(repositorio);
    }
    
    @RequestMapping(value = "/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("empleados",repositorio.ObtenerTodos());
        mv.setViewName("empleados/listar");
        return mv;
    }
}
