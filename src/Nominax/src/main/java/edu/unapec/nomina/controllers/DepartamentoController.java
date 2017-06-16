/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Departamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
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
    public String guardar(Departamentos departamento){
        repositorio.Guardar(departamento);
        return "redirect:listar";
    }
    
    @RequestMapping(value = "/editar/{id}")
    public ModelAndView editar(@PathVariable int id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("departamento",repositorio.ObtenerUno(id));
        mv.setViewName("departamentos/editar");
        return mv;
    }
    
    @RequestMapping(value = "/editar",method = RequestMethod.POST)
    public String editar(Departamentos departamento){
        repositorio.Editar(departamento);
        return "redirect:listar";
    }
    
    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        repositorio.Eliminar(repositorio.ObtenerUno(id));
        return "redirect:/departamentos/listar";
    }
    
    
}
    