package edu.unapec.nomina.dao;

import java.util.List;

public interface IRepositorio<T> {
	public void Guardar(T entidad);
        public void Eliminar(T entidad);
        public T ObtenerUno(int id);
	public List<T> ObtenerTodos();

}
