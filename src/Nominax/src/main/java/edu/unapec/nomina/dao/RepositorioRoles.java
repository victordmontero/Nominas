/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Roles;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author phenom
 */
@Repository
public class RepositorioRoles extends RepositorioBase<Roles>{
    
    @Autowired
    public RepositorioRoles(SessionFactory sf) {
        super(sf);
    }

    public void Guardar(Roles entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(Roles entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(Roles entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public Roles ObtenerUno(int id) {
        Session session = sessionFactory.openSession();
        Criteria crit = session.createCriteria(Roles.class);
        Roles rol = (Roles)crit.add(Restrictions.eq("idRol", id));
        session.close();
        return rol;
    }

    public List<Roles> ObtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Roles> roles = session.createQuery("from Roles").list();
        session.close();
        return roles;
    }
    
}
