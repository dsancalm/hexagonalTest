
package es.hexagonalTest.prueba.application.impl;

import es.hexagonalTest.prueba.application.impl.base.BaseServiceImpl;
import es.hexagonalTest.prueba.application.interfaces.base.IBaseDao;
import es.hexagonalTest.prueba.application.interfaces.dao.MarcaDAO;
import es.hexagonalTest.prueba.application.interfaces.services.MarcaService;
import es.hexagonalTest.prueba.domain.Marca;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class MarcaServiceImpl extends BaseServiceImpl<Marca> implements MarcaService {

	@NonNull
	private final MarcaDAO dao;
	
	@Override
	protected IBaseDao<Marca> getDefaultDao() {
		return dao;
	}



}
