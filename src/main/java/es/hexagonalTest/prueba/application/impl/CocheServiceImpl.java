
package es.hexagonalTest.prueba.application.impl;

import es.hexagonalTest.prueba.application.impl.base.BaseServiceImpl;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.application.interfaces.dao.CocheDAO;
import es.hexagonalTest.prueba.application.interfaces.services.CocheService;
import es.hexagonalTest.prueba.domain.Coche;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class CocheServiceImpl extends BaseServiceImpl<Coche> implements CocheService {

	@NonNull
	private final CocheDAO dao;
	
	@Override
	protected IBaseDao<Coche> getDefaultDao() {
		return dao;
	}



}
