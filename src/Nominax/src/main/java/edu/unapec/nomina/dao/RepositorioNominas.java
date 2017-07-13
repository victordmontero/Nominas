/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Nominas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author phenom
 */
@Repository
public class RepositorioNominas extends RepositorioBase<Nominas>{

    @Autowired
    public RepositorioNominas(SessionFactory sf) {
        super(sf);
    }

    public void Guardar(Nominas entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(Nominas entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(Nominas entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public Nominas ObtenerUno(int id) {
        String hql = String.format("from Nominas "+
                "where idNomina = %d and Estado = 1", id);
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Nominas nomina = (Nominas)query.uniqueResult();
        session.close();
        return nomina;
    }

    public List<Nominas> ObtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Nominas> nominas = 
                session.createQuery("from Nominas where Estado = 1").list();
        session.close();
        return nominas;
    }
    
    
}
