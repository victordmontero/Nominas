/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Empleados;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author phenom
 */
public class RepositorioEmpleados extends RepositorioBase<Empleados>{

    public RepositorioEmpleados(SessionFactory sf) {
        super(sf);
    }

    public void Guardar(Empleados entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(Empleados entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(Empleados entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public Empleados ObtenerUno(int id) {
        String hql = String
                .format("from Empleados "
                        +"where idEmpleado = %d and Estado = 1", id);
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Empleados empleados = (Empleados)query.uniqueResult();
        session.close();
        return empleados;
    }

    public List<Empleados> ObtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Empleados> lista = session.createQuery("from Empleados "+
                "where Estado = 1").list();
        session.close();
        return lista;
    }
    
    
}
