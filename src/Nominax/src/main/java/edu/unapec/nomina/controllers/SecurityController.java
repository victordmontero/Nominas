/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.controllers;

import edu.unapec.nomina.dao.IRepositorio;
import edu.unapec.nomina.dao.RepositorioRoles;
import edu.unapec.nomina.modelos.Roles;
import edu.unapec.nomina.modelos.Usuario;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author phenom
 */
@Controller
@RequestMapping(value = "/security")
public class SecurityController {

    IRepositorio<Usuario> repo;

    @Autowired
    RepositorioRoles repoRoles;

    @Autowired
    public SecurityController(IRepositorio<Usuario> repositorio) {
        this.repo = repositorio;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "security/login";
    }

    @RequestMapping(value = "/signout")
    public String signout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/security/signin?signout";
    }

    @RequestMapping(value = "/denied")
    public String denied() {
        return "security/denied";
    }

    @RequestMapping(value = {"/", "/listar-usuarios"})
    public String listarUsuarios(ModelMap model) {
        try {
            List<Usuario> usuarios = repo.ObtenerTodos();
            model.addAttribute("usuarios", usuarios);
            return "security/listarUsuarios";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/nuevo-usuario")
    public String nuevoUsuario(ModelMap model) {
        try {
            Usuario u = new Usuario();
            model.addAttribute("usuario", u);
            model.addAttribute("roles", repoRoles.ObtenerTodos());
            return "security/guardarUsuario";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/nuevo-usuario", method = RequestMethod.POST)
    public String nuevoUsuario(@Valid Usuario u, BindingResult result, ModelMap map) {
        try {
            PasswordEncoder encoder = new BCryptPasswordEncoder(11);

            if (result.hasErrors()) {
                return "redirect:/security/listar-usuarios";
            }

            u.setPassword(encoder.encode(u.getPassword()));
            repo.Guardar(u);

            return "redirect:/security/listar-usuarios";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/editar-usuario/{id}")
    public String editarUsuario(@PathVariable int id, ModelMap model) {
        try {
            Usuario usuario = repo.ObtenerUno(id);
            usuario.setRoleses(null);
            usuario.setPassword(null);
            model.addAttribute("usuario", usuario);
            model.addAttribute("roles", repoRoles.ObtenerTodos());
            return "security/editarUsuario";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/editar-usuario", method = RequestMethod.POST)
    public String editarUsuario(@Valid Usuario u,
            BindingResult result, ModelMap map) {
        try {
            PasswordEncoder encoder = new BCryptPasswordEncoder(11);

            if (result.hasErrors()) {
                return "security/editarUsuario";
            }

            u.setPassword(encoder.encode(u.getPassword()));

            String var = (String) u.getRoleses().toArray()[0];
            Roles r = repoRoles.ObtenerUno(Integer.parseInt(var));
            Set<Roles> set = new HashSet<Roles>();
            set.add(r);

            u.setRoleses(set);

            repo.Editar(u);
            return "redirect:/security/listar-usuarios";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    @RequestMapping(value = "/eliminar-usuario/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        try {
            repo.Eliminar(repo.ObtenerUno(id));
            return "redirect:/security/listar-usuarios";
        } catch (Exception e) {
            return "/errorPage";
        }
    }

    public RepositorioRoles getRepoRoles() {
        return repoRoles;
    }

    public void setRepoRoles(RepositorioRoles repoRoles) {
        this.repoRoles = repoRoles;
    }

}
