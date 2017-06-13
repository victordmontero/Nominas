/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Departamentos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author phenom
 */
public class RepositorioDepartamentos extends RepositorioBase<Departamentos> {

    public RepositorioDepartamentos(SessionFactory sf) {
        super(sf);
    }

    public void Guardar(Departamentos entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(Departamentos entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(Departamentos entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public Departamentos ObtenerUno(int id) {
        String hql = String
                .format("from Departamentos where idDepartemento = %d "
                        +" and Estado = 1", id);
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Departamentos departamentos = (Departamentos)query.uniqueResult();
        session.close();
        return departamentos;
    }

    public List<Departamentos> ObtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Departamentos> lista = session.createQuery("from Departamentos "
        +"where Estado = 1").list();
        session.close();
        return lista;
    }

}
