package es.hexagonalTest.prueba.application.interfaces.base;

import java.util.List;

import es.hexagonalTest.prueba.application.common.exceptions.DaoException;

public interface IBaseDao<T> {
	T save(T entity) throws DaoException;

	T update(T entity) throws DaoException;

	void remove(T entity) throws DaoException;

	List<T> findAll();
}