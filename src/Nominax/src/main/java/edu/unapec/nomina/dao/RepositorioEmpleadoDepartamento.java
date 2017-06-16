/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.EmpleadoDepartamento;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author phenom
 */
public class RepositorioEmpleadoDepartamento extends RepositorioBase<EmpleadoDepartamento> {

    public RepositorioEmpleadoDepartamento(SessionFactory sf) {
        super(sf);
    }

    public void Guardar(EmpleadoDepartamento entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(EmpleadoDepartamento entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(EmpleadoDepartamento entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public EmpleadoDepartamento ObtenerUno(int id) {
        return null;
    }

    public List<EmpleadoDepartamento> ObtenerTodos() {
        String hql = "from EmpleadoDepartamento";

        Session session = sessionFactory.openSession();
        List<EmpleadoDepartamento> lista = session.createQuery(hql).list();
        session.close();
        return lista;
    }

    public EmpleadoDepartamento ObtenerUno(int idEmpleado, int idDepartamento) {
        String hql = String.format("from EmpleadoDepartamento "
                +"where idEmpleado = %d and "
                +"idDepartamento = %d", idEmpleado,idDepartamento);
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        EmpleadoDepartamento ed = (EmpleadoDepartamento)query.uniqueResult();
        session.close();
        return ed;
    }

}
