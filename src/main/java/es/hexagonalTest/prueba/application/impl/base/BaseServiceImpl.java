package es.hexagonalTest.prueba.application.impl.base;

import es.hexagonalTest.prueba.application.common.Errors;
import es.hexagonalTest.prueba.application.common.exceptions.DaoException;
import es.hexagonalTest.prueba.application.common.exceptions.DeleteException;
import es.hexagonalTest.prueba.application.common.exceptions.SaveException;
import es.hexagonalTest.prueba.application.common.exceptions.UpdateException;
import es.hexagonalTest.prueba.application.common.responses.ResponseService;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseService;
import es.hexagonalTest.prueba.domain.base.BaseDomain;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseServiceImpl<T extends BaseDomain> implements IBaseService<T> {

	protected abstract IBaseDao<T> getDefaultDao();

	@Override
	public ResponseService<T> save(T domain) {
		log.debug("Entrando en el metodo 'save' con el objeto: " + domain);
		ResponseService<T> respuesta = new ResponseService<>();
		try {
			respuesta.setData(this.getDefaultDao().save(domain));
			return respuesta;
		} catch (SaveException e) {
			return new ResponseService<>(Errors.ERROR_SAVE);
		} catch (DaoException e) {
			return new ResponseService<>(Errors.ERROR_GENERIC);
		}
	}

	@Override
	public ResponseService<T> update(T domain) {
		log.debug("Entrando en el metodo 'update' con el objeto: " + domain);
		ResponseService<T> respuesta = new ResponseService<>();
		if (!this.getDefaultDao().existsOne(domain.getId())) {
			return new ResponseService<>(Errors.ERROR_NOT_FOUND);
		}
		try {
			respuesta.setData(this.getDefaultDao().save(domain));
			return respuesta;
		} catch (UpdateException e) {
			return new ResponseService<>(Errors.ERROR_UPDATE);
		} catch (DaoException e) {
			return new ResponseService<>(Errors.ERROR_GENERIC);
		}
	}

	@Override
	public ResponseService<T> remove(T domain) {
		log.debug("Entrando en el metodo 'remove' con el objeto: " + domain);
		if (!this.getDefaultDao().existsOne(domain.getId())) {
			return new ResponseService<>(Errors.ERROR_NOT_FOUND);
		}
		try {
			this.getDefaultDao().remove(domain);
		} catch (DeleteException e) {
			return new ResponseService<>(Errors.ERROR_DELETE);
		} catch (DaoException e) {
			return new ResponseService<>(Errors.ERROR_GENERIC);
		}
		return new ResponseService<>();
	}

	@Override
	public ResponseService<T> findAll() {
		log.debug("Entrando en el metodo 'findAll'");
		ResponseService<T> respuesta = new ResponseService<>();
		respuesta.setListData(getDefaultDao().findAll());
		return respuesta;
	}

}
