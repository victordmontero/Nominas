/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.dao;

import edu.unapec.nomina.modelos.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phenom
 */
@Repository
@Transactional(readOnly = true)
public class RepositorioUsuario extends RepositorioBase<Usuario> {

    @Autowired
    public RepositorioUsuario(SessionFactory sf) {
        super(sf);
    }

    public Usuario getByNombre(String nombre) {
        Session session = sessionFactory.openSession();
        Criteria crit = session.createCriteria(Usuario.class);
        Usuario usuario = (Usuario) crit.add(
                Restrictions.eq("nombre", nombre)).uniqueResult();
        session.close();
        return usuario;
    }

    public void Guardar(Usuario entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(entidad);
        tx.commit();
        session.close();
    }

    public void Editar(Usuario entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(entidad);
        tx.commit();
        session.close();
    }

    public void Eliminar(Usuario entidad) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entidad);
        tx.commit();
        session.close();
    }

    public Usuario ObtenerUno(int id) {
        Session session = sessionFactory.openSession();
        Usuario usuario = (Usuario) session.createQuery("from Usuario where IdUsuario = " + id)
                .uniqueResult();
        session.close();
        return usuario;
    }

    public List<Usuario> ObtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Usuario> usuarios = session.createQuery("from Usuario").list();
        session.close();
        return usuarios;
    }

}
