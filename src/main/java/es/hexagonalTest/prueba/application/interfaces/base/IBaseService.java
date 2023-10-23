package es.hexagonalTest.prueba.application.interfaces.base;

import java.util.List;

public interface IBaseService<T> {
	T save(T domain);

	T update(T domain);

	int remove(T domain);

	List<T> findAll();
}