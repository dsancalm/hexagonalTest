package es.hexagonalTest.prueba.infraestructure.jpa.repository.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import es.hexagonalTest.prueba.application.common.exceptions.DaoException;
import es.hexagonalTest.prueba.application.common.exceptions.DeleteException;
import es.hexagonalTest.prueba.application.common.exceptions.SaveException;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.domain.base.BaseDomain;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseDAOImpl<T extends BaseDomain, S extends Serializable> implements IBaseDao<T> {

	private static final String ERROR = "Error";

	protected abstract JpaRepository<S, Long> getRepository();

	protected abstract BaseMapperEntity<T, S> getDefaultMapper();

	@Override
	public T save(T entity) throws DaoException {
		log.debug("Entrando en el metodo 'save' con el objeto: " + entity);
		try {
			S saved = this.getRepository().save(this.getDefaultMapper().domainToEntity(entity));
			return this.getDefaultMapper().entityToDomain(saved);
		} catch (JpaObjectRetrievalFailureException e) {
			log.error("Error al generar la entidad: " + entity, e);
			throw new SaveException("Error al generar la entidad: " + entity);
		} catch (Exception e) {
			log.error(ERROR, e);
			throw new DaoException(ERROR + entity);
		}

	}

	@Override
	public void remove(T entity) throws DaoException {
		log.debug("Entrando en el metodo 'remove' con el objeto: " + entity);
		try {
			this.getRepository().delete(this.getDefaultMapper().domainToEntity(entity));
		} catch (Exception e) {
			log.error("Error al borrar la entidad: " + entity, e);
			throw new DeleteException("Error al borrar la entidad: " + entity);
		}
	}

	@Override
	public List<T> findAll() {
		log.debug("Entrando en el metodo 'findAll'");
		return this.getDefaultMapper().entitiesToDomains(this.getRepository().findAll());
	}
	
	@Override
	public T findOne(Long id) {
		log.debug("Entrando en el metodo 'findOne'");
		return this.getDefaultMapper().entityToDomain(this.getRepository().getReferenceById(id));
	}
	
	@Override
	public boolean existsOne(Long id) {
		log.debug("Entrando en el metodo 'existsOne'");
		return this.getRepository().existsById(id);
	}

}
