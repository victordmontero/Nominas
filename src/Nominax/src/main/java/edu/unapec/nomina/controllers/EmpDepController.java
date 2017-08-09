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
import edu.unapec.nomina.modelos.EmpleadoDepartamentoId;
import edu.unapec.nomina.modelos.Empleados;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phenom
 */
@Controller
@RequestMapping(value = "/empdep")
public class EmpDepController {

    RepositorioEmpleadoDepartamento repositorio;
    IRepositorio<Empleados> repoEmp;
    IRepositorio<Departamentos> repoDep;

    @Autowired
    public EmpDepController(RepositorioEmpleadoDepartamento repositorio,
            IRepositorio<Empleados> repoEmp, IRepositorio<Departamentos> repoDep) {
        this.repositorio = repositorio;
        this.repoEmp = repoEmp;
        this.repoDep = repoDep;
    }

    @RequestMapping(value = {"/", "/listar"})
    public ModelAndView listar() {
        try {
            ModelAndView mv = new ModelAndView("empdep/listar");
            mv.addObject("empdeps", repositorio.ObtenerTodos());
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/guardar")
    public ModelAndView guardar() {
        try {
            ModelAndView mv = new ModelAndView("empdep/guardar");
            mv.addObject("empdep", new EmpleadoDepartamento());
            mv.addObject("emps", repoEmp.ObtenerTodos());
            mv.addObject("departamentos", repoDep.ObtenerTodos());
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(EmpleadoDepartamento model) {
        try {
            repositorio.Guardar(model);
            return "redirect:listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/editar/{idEmpleado}/{idDepartamento}")
    public ModelAndView editar(@PathVariable int idEmpleado,
            @PathVariable int idDepartamento) {
        try {
            ModelAndView mv = new ModelAndView("empdep/editar");
            RepositorioEmpleadoDepartamento repo = (RepositorioEmpleadoDepartamento) repositorio;
            mv.addObject("empdep", repo.ObtenerUno(idEmpleado, idDepartamento));
            mv.addObject("emps", repoEmp.ObtenerTodos());
            mv.addObject("departamentos", repoDep.ObtenerTodos());
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(EmpleadoDepartamento model, @RequestParam int DepId, @RequestParam int EmpId) {
        try {
            EmpleadoDepartamento temp = new EmpleadoDepartamento(model.getId(), model.getDepartamentos(), model.getEmpleados());
            model.setId(new EmpleadoDepartamentoId(EmpId, DepId));
            repositorio.Eliminar(repositorio.ObtenerUno(model.getId().getIdEmpleado(), model.getId().getIdDepartamento()));
            temp.setDepartamentos(repoDep.ObtenerUno(temp.getId().getIdDepartamento()));
            temp.setEmpleados(repoEmp.ObtenerUno(temp.getId().getIdEmpleado()));
            repositorio.Guardar(temp);
            return "redirect:listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/eliminar/{idEmpleado}/{idDepartamento}")
    public String eliminar(@PathVariable int idEmpleado,
            @PathVariable int idDepartamento) {
        try {
            RepositorioEmpleadoDepartamento repo = (RepositorioEmpleadoDepartamento) repositorio;
            repositorio.Eliminar(repo.ObtenerUno(idEmpleado, idDepartamento));
            return "redirect:/empdep/listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

}
