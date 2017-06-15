/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Departamentos;
import edu.unapec.nomina.modelos.Empleados;
import edu.unapec.nomina.modelos.Puestos;
import org.springframework.stereotype.Controller;
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

    public EmpleadoController(IRepositorio<Empleados> repositorio, 
            IRepositorio<Puestos> repoPuestos, IRepositorio<Departamentos> repoDepartamentos) {
        super(repositorio);
        this.repoPuestos = repoPuestos;
        this.repoDepartamentos = repoDepartamentos;
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
        String[] nominas = {"Contabilidad", "TI"};
        mv.addObject("empleado", new Empleados());
        mv.addObject("puestos", repoPuestos.ObtenerTodos());
        mv.addObject("departamentos",repoDepartamentos.ObtenerTodos());
        mv.addObject("nominas", nominas);
        mv.setViewName("empleados/guardar");
        return mv;
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ModelAndView guardar(Empleados empleado) {
        ModelAndView mv = new ModelAndView();
        repositorio.Guardar(empleado);
        mv.setViewName("redirect:listar");
        return mv;
    }
}
