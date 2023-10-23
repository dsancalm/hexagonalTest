package es.hexagonalTest.prueba.infraestructure.jpa.repository.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.hexagonalTest.prueba.application.common.exceptions.DaoException;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseDAOImpl<T, S extends Serializable> implements IBaseDao<T> {

	protected abstract JpaRepository<S, Long> getRepository();

	protected abstract BaseMapperEntity<T, S> getDefaultMapper();

	@Override
	public T save(T entity) throws DaoException {
		log.debug("Entrando en el metodo 'save' con el objeto: " + entity);
		try {
			S saved = this.getRepository().save(this.getDefaultMapper().domainToEntity(entity));
			return this.getDefaultMapper().entityToDomain(saved);
		} catch (EntityNotFoundException e) {
			log.error("Error al generar la entidad: " + entity, e);
			throw new DaoException("Error al generar la entidad: " + entity);
		} catch (Exception e) {
			log.error("Error", e);
			throw new DaoException("Error" + entity);
		}

	}

	@Override
	public T update(T entity) throws DaoException {
		log.debug("Entrando en el metodo 'update' con el objeto: " + entity);
		try {
			S updated = this.getRepository().save(this.getDefaultMapper().domainToEntity(entity));
			return this.getDefaultMapper().entityToDomain(updated);
		} catch (EntityNotFoundException e) {
			log.error("Error al actualizar la entidad: " + entity, e);
			throw new DaoException("Error al actualizar la entidad: " + entity);
		} catch (Exception e) {
			log.error("Error", e);
			throw new DaoException("Error" + entity);
		}
	}

	@Override
	public int remove(T entity) throws DaoException {
		log.debug("Entrando en el metodo 'remove' con el objeto: " + entity);
		try {
			this.getRepository().delete(this.getDefaultMapper().domainToEntity(entity));
		} catch (Exception e) {
			log.error("Error al borrar la entidad: " + entity, e);
			throw new DaoException("Error al borrar la entidad: " + entity);
		}
		return 0;
	}

	@Override
	public List<T> findAll() {
		log.debug("Entrando en el metodo 'findAll'");
		return this.getDefaultMapper().entitiesToDomains(this.getRepository().findAll());
	}

}
