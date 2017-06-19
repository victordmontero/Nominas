/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Transacciones;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author phenom
 */
public class RepositorioTransacciones extends RepositorioBase<Transacciones> {

    @Autowired
    public RepositorioTransacciones(SessionFactory sf) {
        super(sf);
    }

    public void Guardar(Transacciones entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(Transacciones entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(Transacciones entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public Transacciones ObtenerUno(int id) {
        String hql = String
                .format("from Transacciones where idTransaccion = %d "
                        + "and Estado = 1", id);
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Transacciones tx = (Transacciones) query.uniqueResult();
        session.close();
        return tx;
    }

    public List<Transacciones> ObtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Transacciones> lista = session.createQuery("from Transacciones "
                + "where Estado = 1").list();
        session.close();
        return lista;
    }

}
