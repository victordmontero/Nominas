/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.TipoIngresoDeduccion;
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
public class RepositorioTipoIngresoDeduccion extends RepositorioBase<TipoIngresoDeduccion> {

    @Autowired
    public RepositorioTipoIngresoDeduccion(SessionFactory sf) {
        super(sf);
    }

    public void Guardar(TipoIngresoDeduccion entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(TipoIngresoDeduccion entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(TipoIngresoDeduccion entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public TipoIngresoDeduccion ObtenerUno(int id) {
        String hql
                = String.format("from TipoIngresoDeduccion "
                        + "where IdTipoIngresoDeduccion = %d and Estado = 1", id);
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        TipoIngresoDeduccion tipoingresodeduccion = (TipoIngresoDeduccion) query.uniqueResult();
        session.close();
        return tipoingresodeduccion;
    }

    public List<TipoIngresoDeduccion> ObtenerTodos() {
        Session session = sessionFactory.openSession();
        List<TipoIngresoDeduccion> tipos
                = session.createQuery("from TipoIngresoDeduccion where Estado = 1")
                        .list();
        session.close();
        return tipos;
    }

}
