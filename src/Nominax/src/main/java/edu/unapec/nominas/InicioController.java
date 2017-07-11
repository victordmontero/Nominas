/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nominas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author phenom
 */
@Controller
public class InicioController {

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        return "admin";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        return "denied";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}
