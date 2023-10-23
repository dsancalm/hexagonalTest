package es.hexagonalTest.prueba.infraestructure.jpa.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import es.hexagonalTest.prueba.application.interfaces.dao.ExtraDAO;
import es.hexagonalTest.prueba.domain.Extra;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.full.ExtraMapper;
import es.hexagonalTest.prueba.infraestructure.jpa.model.ExtraEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.repository.ExtraRepository;
import es.hexagonalTest.prueba.infraestructure.jpa.repository.base.BaseDAOImpl;

@Service
public class ExtraDAOImpl extends BaseDAOImpl<Extra, ExtraEntity> implements ExtraDAO {
	
	@Autowired
	private ExtraRepository repository;
	
	@Autowired
	private ExtraMapper mapper; 

	@Override
	protected JpaRepository<ExtraEntity, Long> getRepository() {
		return repository;
	}

	@Override
	protected BaseMapperEntity<Extra, ExtraEntity> getDefaultMapper() {
		return mapper;
	}



}
