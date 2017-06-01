package edu.unapec.nomina.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.unapec.nomina.modelos.Persona;

public class PersonaDAO implements IDao<Persona> {

	private SessionFactory sessionFactory;
	
	
	public PersonaDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void Guardar(Persona entidad) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(entidad);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Persona> Listar() {
		Session session = this.sessionFactory.openSession();
		List<Persona> personas = session.createQuery("from personas").list();
		session.close();
		return personas;
	}
	
	

}
