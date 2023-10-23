package es.hexagonalTest.prueba.application.interfaces.base;

import java.util.List;

import es.hexagonalTest.prueba.application.common.exceptions.DaoException;

public interface IBaseDao<T> {
	T save(T entity);

	T update(T entity);

	int remove(T entity) throws DaoException;

	List<T> findAll();
}