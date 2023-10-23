package es.hexagonalTest.prueba.application.interfaces.base;

import java.util.List;

import es.hexagonalTest.prueba.application.common.exceptions.ServiceException;

public interface IBaseService<T> {
	T save(T domain);

	T update(T domain);

	int remove(T domain) throws ServiceException;

	List<T> findAll();
}