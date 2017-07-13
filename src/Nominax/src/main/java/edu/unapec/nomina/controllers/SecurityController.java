/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author phenom
 */
@Controller
public class SecurityController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "login";
    }

    @RequestMapping(value = "/signout")
    public String signout() {
        return "login?logout";
    }

}
