package es.hexagonalTest.prueba.infraestructure.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import es.hexagonalTest.prueba.application.interfaces.CocheDAO;
import es.hexagonalTest.prueba.domain.Coche;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.CocheMapper;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.CocheEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.repository.base.BaseDAOImpl;

@Service
public class CocheDAOImpl extends BaseDAOImpl<Coche, CocheEntity> implements CocheDAO {
	
	@Autowired
	private CocheRepository repository;
	
	@Autowired
	private CocheMapper mapper;

	@Override
	protected JpaRepository<CocheEntity, Long> getRepository() {
		return repository;
	}

	@Override
	protected BaseMapperEntity<Coche, CocheEntity> getDefaultMapper() {
		return mapper;
	}



}
