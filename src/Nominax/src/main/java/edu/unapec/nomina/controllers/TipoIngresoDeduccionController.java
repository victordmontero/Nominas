/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.TipoIngresoDeduccion;
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
@RequestMapping(value = "/tid")
public class TipoIngresoDeduccionController extends CRUDController<TipoIngresoDeduccion> {

    @Autowired
    public TipoIngresoDeduccionController(IRepositorio<TipoIngresoDeduccion> repositorio) {
        super(repositorio);
    }

    @Override
    @RequestMapping(value = {"/", "/listar"})
    public ModelAndView listar() {
        try {
            ModelAndView mv = new ModelAndView("tid/listar");
            mv.addObject("tids", repositorio.ObtenerTodos());
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/guardar")
    public ModelAndView guardar() {
        try {
            HashMap<Character, String> tipos = new HashMap<Character, String>();
            tipos.put('I', "Ingreso");
            tipos.put('D', "Deduccion");
            ModelAndView mv = new ModelAndView("tid/guardar");
            mv.addObject("tipos", tipos);
            mv.addObject("tid", new TipoIngresoDeduccion());
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(TipoIngresoDeduccion tipoingresodeduccion) {
        try {
            repositorio.Guardar(tipoingresodeduccion);
            return "redirect:listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/editar/{id}")
    public ModelAndView editar(@PathVariable int id) {
        try {
            HashMap<Character, String> tipos = new HashMap<Character, String>();
            tipos.put('I', "Ingreso");
            tipos.put('D', "Deduccion");
            ModelAndView mv = new ModelAndView("tid/editar");
            TipoIngresoDeduccion tipoID = repositorio.ObtenerUno(id);
            mv.addObject("tid", tipoID);
            mv.addObject("tipos", tipos);
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(TipoIngresoDeduccion tipoID) {
        try {
            repositorio.Editar(tipoID);
            return "redirect:listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        try {
            TipoIngresoDeduccion tipoID = repositorio.ObtenerUno(id);
            repositorio.Eliminar(tipoID);
            return "redirect:/tid/listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

}
