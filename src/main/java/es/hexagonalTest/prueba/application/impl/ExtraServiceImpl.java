
package es.hexagonalTest.prueba.application.impl;

import es.hexagonalTest.prueba.application.impl.base.BaseServiceImpl;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.application.interfaces.dao.ExtraDAO;
import es.hexagonalTest.prueba.application.interfaces.services.ExtraService;
import es.hexagonalTest.prueba.domain.Extra;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class ExtraServiceImpl extends BaseServiceImpl<Extra> implements ExtraService {

	@NonNull
	private final ExtraDAO dao;
	
	@Override
	protected IBaseDao<Extra> getDefaultDao() {
		return dao;
	}



}
