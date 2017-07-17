package edu.unapec.nomina.modelos;
// Generated Jul 14, 2017 11:56:20 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Roles generated by hbm2java
 */
public class Roles  implements java.io.Serializable {


     private Integer idRol;
     private String nombreRole;
     private boolean estado;
     private Set usuarios = new HashSet(0);

    public Roles() {
    }

	
    public Roles(String nombreRole, boolean estado) {
        this.nombreRole = nombreRole;
        this.estado = estado;
    }
    public Roles(String nombreRole, boolean estado, Set usuarios) {
       this.nombreRole = nombreRole;
       this.estado = estado;
       this.usuarios = usuarios;
    }
   
    public Integer getIdRol() {
        return this.idRol;
    }
    
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    public String getNombreRole() {
        return this.nombreRole;
    }
    
    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


