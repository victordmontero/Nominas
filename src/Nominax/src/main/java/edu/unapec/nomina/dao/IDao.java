package edu.unapec.nomina.dao;

import java.util.List;

public interface IDao<T> {
	public void Guardar(T entidad);
	public List<T> Listar();

}
