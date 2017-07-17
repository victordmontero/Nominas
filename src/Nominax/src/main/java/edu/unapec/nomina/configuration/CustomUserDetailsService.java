/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.configuration;

import edu.unapec.nomina.dao.RepositorioUsuario;
import edu.unapec.nomina.modelos.Roles;
import edu.unapec.nomina.modelos.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author phenom
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    public RepositorioUsuario repo;
    
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        Usuario usuario = repo.getByNombre(string);
        if (usuario == null) {
            throw new UsernameNotFoundException(string);
        }
        return new User(usuario.getNombre(), usuario.getPassword(), true, true, true, true, getAuthorities(usuario));
    }
    
    public List<GrantedAuthority> getAuthorities(Usuario usuario) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (int i = 0; i < usuario.getRoleses().size(); i++) {
            Roles rol = (Roles) usuario.getRoleses().toArray()[i];
            String nombreRol = String.format("ROLE_%s", rol.getNombreRole());
            authorities.add(new SimpleGrantedAuthority(nombreRol));
        }
        return authorities;
    }
}
