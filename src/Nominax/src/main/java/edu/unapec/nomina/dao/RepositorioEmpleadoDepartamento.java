/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Empleadodepartamento;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Empleadodepartamento> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
