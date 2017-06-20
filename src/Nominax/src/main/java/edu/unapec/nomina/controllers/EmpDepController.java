/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.dao.RepositorioEmpleadoDepartamento;
import edu.unapec.nomina.modelos.Departamentos;
import edu.unapec.nomina.modelos.EmpleadoDepartamento;
import edu.unapec.nomina.modelos.Empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phenom
 */
@RequestMapping(value = "/empdep")
public class EmpDepController {

    IRepositorio<EmpleadoDepartamento> repositorio;
    IRepositorio<Empleados> repoEmp;
    IRepositorio<Departamentos> repoDep;

    @Autowired
    public EmpDepController(IRepositorio<EmpleadoDepartamento> repositorio,
            IRepositorio<Empleados> repoEmp, IRepositorio<Departamentos> repoDep) {
        this.repositorio = repositorio;
        this.repoEmp = repoEmp;
        this.repoDep = repoDep;
    }

    @RequestMapping(value = {"/", "/listar"})
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("empdep/listar");
        mv.addObject("empdeps", repositorio.ObtenerTodos());
        return mv;
    }

    @RequestMapping(value = "/guardar")
    public ModelAndView guardar() {
        ModelAndView mv = new ModelAndView("empdep/guardar");
        mv.addObject("empdep", new EmpleadoDepartamento());
        mv.addObject("emps", repoEmp.ObtenerTodos());
        mv.addObject("departamentos", repoDep.ObtenerTodos());
        return mv;
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(EmpleadoDepartamento model) {
        repositorio.Guardar(model);
        return "redirect:listar";
    }

    @RequestMapping(value = "/editar/{idEmpleado}/{idDepartamento}")
    public ModelAndView editar(@PathVariable int idEmpleado,
            @PathVariable int idDepartamento) {
        ModelAndView mv = new ModelAndView("empdep/editar");
        RepositorioEmpleadoDepartamento repo = (RepositorioEmpleadoDepartamento) repositorio;
        mv.addObject("empdep", repo.ObtenerUno(idEmpleado, idDepartamento));
        mv.addObject("emps", repoEmp.ObtenerTodos());
        mv.addObject("departamentos", repoDep.ObtenerTodos());
        return mv;
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(EmpleadoDepartamento model) {
        repositorio.Editar(model);
        return "redirect:listar";
    }

    @RequestMapping(value = "/eliminar/{idEmpleado}/{idDepartamento}")
    public String eliminar(@PathVariable int idEmpleado,
            @PathVariable int idDepartamento) {
        RepositorioEmpleadoDepartamento repo = (RepositorioEmpleadoDepartamento) repositorio;
        repositorio.Eliminar(repo.ObtenerUno(idEmpleado, idDepartamento));
        return "redirect:/empdep/listar";
    }

}
