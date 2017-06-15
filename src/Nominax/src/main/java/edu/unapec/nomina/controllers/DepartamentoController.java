/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Departamentos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phenom
 */
@Controller
@RequestMapping(value = "/departamentos")
public class DepartamentoController extends CRUDController<Departamentos>{

    public DepartamentoController(IRepositorio<Departamentos> repositorio) {
        super(repositorio);
    }
    
    @RequestMapping(value = "/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("departamentos",repositorio.ObtenerTodos());
        mv.setViewName("departamentos/listar");
        return mv;
    }
    
    @RequestMapping(value = "/guardar")
    public ModelAndView guardar(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("departamento",new Departamentos());
        mv.setViewName("departamentos/guardar");
        return mv;
    }
    
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public ModelAndView guardar(Departamentos departamento){
        ModelAndView mv = new ModelAndView();
        repositorio.Guardar(departamento);
        mv.setViewName("redirect:listar");
        return mv;
    }
}
    