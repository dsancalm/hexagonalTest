
package es.hexagonalTest.prueba.application.impl;

import es.hexagonalTest.prueba.application.impl.base.BaseServiceImpl;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.application.interfaces.dao.PrecioDAO;
import es.hexagonalTest.prueba.application.interfaces.services.PrecioService;
import es.hexagonalTest.prueba.domain.Precio;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class PrecioServiceImpl extends BaseServiceImpl<Precio> implements PrecioService {

	@NonNull
	private final PrecioDAO dao;
	
	@Override
	protected IBaseDao<Precio> getDefaultDao() {
		return dao;
	}



}
