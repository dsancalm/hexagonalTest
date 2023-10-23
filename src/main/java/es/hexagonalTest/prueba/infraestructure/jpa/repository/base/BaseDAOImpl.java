package es.hexagonalTest.prueba.infraestructure.jpa.repository.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseDAOImpl<T, S extends Serializable> implements IBaseDao<T> {

	protected abstract JpaRepository<S, Long> getRepository();

	protected abstract BaseMapperEntity<T, S> getDefaultMapper();

	@Override
	public T save(T entity) {
		log.debug("Entrando en el metodo 'save' con el objeto: " + entity);
		return null;
	}

	@Override
	public T update(T entity) {
		log.debug("Entrando en el metodo 'update' con el objeto: " + entity);
		return null;
	}

	@Override
	public int remove(T entity) {
		log.debug("Entrando en el metodo 'remove' con el objeto: " + entity);
		return 0;
	}

	@Override
	public List<T> findAll() {
		log.debug("Entrando en el metodo 'findAll'");
		return null;
	}

}
