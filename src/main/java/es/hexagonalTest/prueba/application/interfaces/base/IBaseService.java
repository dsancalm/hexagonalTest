package es.hexagonalTest.prueba.application.interfaces.base;

import es.hexagonalTest.prueba.application.common.responses.ResponseService;

public interface IBaseService<T> {
	ResponseService<T> save(T domain);

	ResponseService<T> update(T domain);

	ResponseService<T> remove(T domain);

	ResponseService<T> findAll();
}