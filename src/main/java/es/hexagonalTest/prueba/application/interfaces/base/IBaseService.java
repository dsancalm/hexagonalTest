package es.hexagonalTest.prueba.application.interfaces.base;

import es.hexagonalTest.prueba.application.common.responses.ResponseService;
import es.hexagonalTest.prueba.domain.base.BaseDomain;

/**
 * Conector para la capa de infraestructura
 *
 * @param <T> the generic type
 */
public interface IBaseService<T extends BaseDomain> {
	ResponseService<T> save(T domain);

	ResponseService<T> update(T domain);

	ResponseService<T> remove(T domain);

	ResponseService<T> findAll();
}