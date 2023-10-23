package es.hexagonalTest.prueba.infraestructure.jpa.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import es.hexagonalTest.prueba.application.interfaces.dao.PrecioDAO;
import es.hexagonalTest.prueba.domain.Precio;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.full.PrecioMapper;
import es.hexagonalTest.prueba.infraestructure.jpa.model.PrecioEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.repository.PrecioRepository;
import es.hexagonalTest.prueba.infraestructure.jpa.repository.base.BaseDAOImpl;

@Service
public class PrecioDAOImpl extends BaseDAOImpl<Precio, PrecioEntity> implements PrecioDAO {
	
	@Autowired
	private PrecioRepository repository;
	
	@Autowired
	private PrecioMapper mapper; 

	@Override
	protected JpaRepository<PrecioEntity, Long> getRepository() { 
		return repository;
	}

	@Override
	protected BaseMapperEntity<Precio, PrecioEntity> getDefaultMapper() {
		return mapper;
	}



}
