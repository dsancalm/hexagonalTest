package es.hexagonalTest.prueba.application.impl.base;

import java.util.List;

import es.hexagonalTest.prueba.application.common.exceptions.DaoException;
import es.hexagonalTest.prueba.application.common.exceptions.ServiceException;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
	
	protected abstract IBaseDao<T> getDefaultDao();

	@Override
	public T save(T domain) {
		log.debug("Entrando en el metodo 'save' con el objeto: " + domain);
		return this.getDefaultDao().save(domain);
	}

	@Override
	public T update(T domain) {
		log.debug("Entrando en el metodo 'update' con el objeto: " + domain);
		return this.getDefaultDao().update(domain);
	}

	@Override
	public int remove(T domain) throws ServiceException {
		log.debug("Entrando en el metodo 'remove' con el objeto: " + domain);
		try {
			this.getDefaultDao().remove(domain);
		} catch (DaoException e) {
			log.debug("Fallo en el borrado");
			throw new ServiceException("Fallo en el borrado");
		}
		return 0;
	}

	@Override
	public List<T> findAll() {
		log.debug("Entrando en el metodo 'findAll'");
		return getDefaultDao().findAll();
	}


}
