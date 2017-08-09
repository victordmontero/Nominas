/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.modelos.Empleados;
import edu.unapec.nomina.modelos.TipoIngresoDeduccion;
import edu.unapec.nomina.modelos.Transacciones;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phenom
 */
@Controller
@RequestMapping(value = "/transacciones")
public class TransaccionController extends CRUDController<Transacciones> {

    @Autowired
    IRepositorio<Empleados> repoEmp;

    @Autowired
    IRepositorio<TipoIngresoDeduccion> repoTid;

    @Autowired
    public TransaccionController(IRepositorio<Transacciones> repositorio) {
        super(repositorio);
    }

    @Override
    @RequestMapping(value = {"/", "/listar"})
    public ModelAndView listar() {
        try {
            ModelAndView mv = new ModelAndView("transacciones/listar");
            mv.addObject("transacciones", repositorio.ObtenerTodos());
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @Override
    @RequestMapping(value = "/nueva")
    public ModelAndView guardar() {
        try {
            ModelAndView mv = new ModelAndView("transacciones/nueva");
            Transacciones tx = new Transacciones();
            tx.setFecha(new Date());
            mv.addObject("transaccion", tx);
            mv.addObject("empleados", repoEmp.ObtenerTodos());
            mv.addObject("tids", repoTid.ObtenerTodos());
            return mv;
        } catch (Exception e) {
            return new ModelAndView("/errorPage");
        }
    }

    @Override
    @RequestMapping(value = "/nueva", method = RequestMethod.POST)
    public String guardar(Transacciones model) {
        try {
            repositorio.Guardar(model);
            return "redirect:listar";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @Override
    public ModelAndView editar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editar(Transacciones model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
