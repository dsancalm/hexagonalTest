package es.hexagonalTest.prueba.application.interfaces.base;

import java.util.List;

public interface IBaseDao<T> {
	T save(T entity);

	T update(T entity);

	int remove(T entity);

	List<T> findAll();
}