package es.hexagonalTest.prueba.application.interfaces.base;

import java.util.List;

import es.hexagonalTest.prueba.application.common.exceptions.DaoException;
import es.hexagonalTest.prueba.domain.base.BaseDomain;

public interface IBaseDao<T extends BaseDomain> {
	T save(T entity) throws DaoException;

	void remove(T entity) throws DaoException;

	List<T> findAll();

	T findOne(Long id);

	boolean existsOne(Long id);
}