/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Phenom
 */
public abstract class CRUDController<T> {
    IRepositorio<T> repositorio;

    public CRUDController(IRepositorio<T> repositorio) {
        this.repositorio = repositorio;
    }
    
    public abstract ModelAndView listar();
    
    public abstract ModelAndView guardar();
    
    public abstract String guardar(T model);
    
    public abstract ModelAndView editar(int id);
    
    public abstract String editar(T model);
    
    public abstract String eliminar(int id);
    
}
