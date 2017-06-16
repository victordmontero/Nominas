/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Departamentos;
import edu.unapec.nomina.modelos.Empleados;
import edu.unapec.nomina.modelos.Nominas;
import edu.unapec.nomina.modelos.Puestos;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phenom
 */
@Controller
@RequestMapping(value = "/empleados")
public class EmpleadoController extends CRUDController<Empleados> {

    IRepositorio<Puestos> repoPuestos;
    IRepositorio<Departamentos> repoDepartamentos;
    IRepositorio<Nominas> repoNominas;

    @Autowired
    public EmpleadoController(IRepositorio<Empleados> repositorio,
            IRepositorio<Puestos> repoPuestos,
            IRepositorio<Departamentos> repoDepartamentos,
            IRepositorio<Nominas> repoNominas) {
        super(repositorio);
        this.repoPuestos = repoPuestos;
        this.repoDepartamentos = repoDepartamentos;
        this.repoNominas = repoNominas;
    }

    @RequestMapping(value = "/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("empleados", repositorio.ObtenerTodos());
        mv.setViewName("empleados/listar");
        return mv;
    }

    @RequestMapping(value = "/guardar")
    public ModelAndView guardar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("empleado", new Empleados());
        mv.addObject("puestos", repoPuestos.ObtenerTodos());
        mv.addObject("departamentos", repoDepartamentos.ObtenerTodos());
        mv.addObject("nominas", repoNominas.ObtenerTodos());
        mv.setViewName("empleados/guardar");
        return mv;
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Empleados empleado) {
        repositorio.Guardar(empleado);
        return "redirect:listar";
    }

    @RequestMapping(value = "/editar/{id}")
    public ModelAndView editar(@PathVariable int id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("empleado", repositorio.ObtenerUno(id));
        mv.addObject("puestos", repoPuestos.ObtenerTodos());
        mv.addObject("departamentos", repoDepartamentos.ObtenerTodos());
        mv.addObject("nominas", repoNominas.ObtenerTodos());
        mv.setViewName("empleados/editar");
        return mv;
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(Empleados empleados) {
        repositorio.Editar(empleados);
        return "redirect:listar";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        repositorio.Eliminar(repositorio.ObtenerUno(id));
        return "redirect:/empleados/listar";
    }
}
