/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Empleadodepartamento;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author phenom
 */
public class RepositorioEmpleadoDepartamento extends RepositorioBase<Empleadodepartamento> {

    public RepositorioEmpleadoDepartamento(SessionFactory sf) {
        super(sf);
    }

    public void Guardar(Empleadodepartamento entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(Empleadodepartamento entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(Empleadodepartamento entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public Empleadodepartamento ObtenerUno(int id) {
        return null;
    }

    public List<Empleadodepartamento> ObtenerTodos() {
        String hql = "from EmpleadoDepartamento";

        Session session = sessionFactory.openSession();
        List<Empleadodepartamento> lista = session.createQuery(hql).list();
        session.close();
        return lista;
    }

    public Empleadodepartamento ObtenerUno(int idEmpleado, int idDepartamento) {
        String hql = String.format("from EmpleadoDepartamento "
                +"where idEmpleado = %d and "
                +"idDepartamento = %d", idEmpleado,idDepartamento);
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Empleadodepartamento ed = (Empleadodepartamento)query.uniqueResult();
        session.close();
        return ed;
    }

}
