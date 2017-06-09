/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Puestos;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author Phenom
 */
public class RepositorioPuestos implements IRepositorio<Puestos>{
    
    SessionFactory sessionFactory;
    
    public RepositorioPuestos(SessionFactory sf){
        sessionFactory = sf;
    }
    
    public void Guardar(Puestos entidad) { 
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(Puestos entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public List<Puestos> ObtenerTodos() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Puestos> lista = session.createQuery("from Puestos").list();
        session.close();
        
        return lista;
    }

    public Puestos ObtenerUno(int id) {
        String hql = String.format("from Puestos where IdPuesto = %d", id);
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Puestos puesto = (Puestos)query.uniqueResult();
        session.close();
        return puesto;
    }

    public void Editar(Puestos entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    
    
    
}
