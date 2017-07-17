/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Nominas;
import java.util.HashMap;
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
@RequestMapping(value = "/nominas")
public class NominaController extends CRUDController<Nominas> {

    @Autowired
    public NominaController(IRepositorio<Nominas> repositorio) {
        super(repositorio);
    }

    @Override
    @RequestMapping(value = {"/", "/listar"})
    public ModelAndView listar() {
        HashMap<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("nominas", repositorio.ObtenerTodos());
        return new ModelAndView("nominas/listar", mapa);
    }

    @Override
    @RequestMapping(value = "/guardar")
    public ModelAndView guardar() {
        ModelAndView mv = new ModelAndView("nominas/guardar");
        mv.addObject("nomina", new Nominas());
        return mv;
    }

    @Override
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Nominas model) {
        repositorio.Guardar(model);
        return "redirect:listar";
    }

    @Override
    @RequestMapping(value = "/editar/{id}")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("nominas/editar");
        mv.addObject("nomina", repositorio.ObtenerUno(id));
        return mv;
    }

    @Override
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(Nominas model) {
        repositorio.Editar(model);
        return "redirect:listar";
    }

    @Override
    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        repositorio.Eliminar(repositorio.ObtenerUno(id));
        return "redirect:/nominas/listar";
    }

}
