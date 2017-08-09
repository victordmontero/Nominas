/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Puestos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 20150569
 */
@Controller
@RequestMapping(value = "/puestos")
public class PuestoController extends CRUDController<Puestos> {

    @Autowired
    public PuestoController(IRepositorio<Puestos> repositorio) {
        super(repositorio);
    }

    @RequestMapping(value = {"/", "/listar"})
    public ModelAndView listar() {
        try {
            ModelAndView mv = new ModelAndView();
            mv.addObject("puestos", repositorio.ObtenerTodos());
            mv.setViewName("puestos/listar");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/guardar")
    public ModelAndView guardar() {
        try {
            ModelAndView mv = new ModelAndView();
            mv.addObject("puesto", new Puestos());
            String[] riesgos = {"Alto", "Medio", "Bajo"};
            mv.addObject("riesgos", riesgos);
            mv.setViewName("puestos/guardar");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Puestos puesto) {
        try {
            puesto.setEstado(true);
            repositorio.Guardar(puesto);
            return "redirect:listar";
        } catch (Exception e) {
            return "/errorPage";
        }

    }

    @RequestMapping(value = "/editar/{idPuesto}")
    public ModelAndView editar(@PathVariable int idPuesto) {
        try {
            ModelAndView mv = new ModelAndView();
            Puestos puesto = repositorio.ObtenerUno(idPuesto);
            mv.addObject("puesto", puesto);
            String[] riesgos = {"Alto", "Medio", "Bajo"};
            mv.addObject("riesgos", riesgos);
            mv.setViewName("puestos/editar");
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(Puestos puesto) {
        try {
            repositorio.Editar(puesto);
            return "redirect:listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/eliminar/{idPuesto}")
    public String eliminar(@PathVariable int idPuesto) {
        try {
            Puestos puesto = repositorio.ObtenerUno(idPuesto);
            repositorio.Eliminar(puesto);
            return "redirect:/puestos/listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }
}
