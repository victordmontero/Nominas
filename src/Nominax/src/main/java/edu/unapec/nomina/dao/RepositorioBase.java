/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import org.hibernate.SessionFactory;

/**
 *
 * @author phenom
 */
public abstract class RepositorioBase<T> implements IRepositorio<T>{
    
    SessionFactory sessionFactory;

    public RepositorioBase(SessionFactory sf) {
        this.sessionFactory = sf;
    }
}
