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
public class DepartamentoController extends CRUDController<Departamentos> {

    @Autowired
    public DepartamentoController(IRepositorio<Departamentos> repositorio) {
        super(repositorio);
    }

    @RequestMapping(value = {"/", "/listar"})
    public ModelAndView listar() {
        try {
            ModelAndView mv = new ModelAndView();
            mv.addObject("departamentos", repositorio.ObtenerTodos());
            mv.setViewName("departamentos/listar");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/guardar")
    public ModelAndView guardar() {
        try {
            ModelAndView mv = new ModelAndView();
            mv.addObject("departamento", new Departamentos());
            mv.setViewName("departamentos/guardar");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Departamentos departamento) {
        try {
            repositorio.Guardar(departamento);
            return "redirect:/departamentos/listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/editar/{id}")
    public ModelAndView editar(@PathVariable int id) {
        try {
            ModelAndView mv = new ModelAndView();
            mv.addObject("departamento", repositorio.ObtenerUno(id));
            mv.setViewName("departamentos/editar");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(Departamentos departamento) {
        try {
            repositorio.Editar(departamento);
            return "redirect:listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        try {
            repositorio.Eliminar(repositorio.ObtenerUno(id));
            return "redirect:/departamentos/listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/consulta")
    public String consultar() {
        return "departamentos/consulta";
    }
}
