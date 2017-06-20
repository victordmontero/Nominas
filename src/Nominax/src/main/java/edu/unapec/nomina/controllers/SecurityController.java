/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phenom
 */
@Controller
public class SecurityController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String logout) {
        ModelAndView mv = new ModelAndView("login");

        if (error != null) {
            mv.addObject("error", "Usuario o Clave invalida");
        }

        if (logout != null) {
            mv.addObject("msg", "Has cerrado sesion correctamente");
        }
        return mv;
    }
}
