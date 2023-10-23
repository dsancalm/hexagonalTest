package es.hexagonalTest.prueba.infraestructure.jpa.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.hexagonalTest.prueba.application.interfaces.dao.MarcaDAO;
import es.hexagonalTest.prueba.domain.Marca;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.full.MarcaMapper;
import es.hexagonalTest.prueba.infraestructure.jpa.model.MarcaEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.repository.MarcaRepository;
import es.hexagonalTest.prueba.infraestructure.jpa.repository.base.BaseDAOImpl;

@Service
@Transactional
public class MarcaDAOImpl extends BaseDAOImpl<Marca, MarcaEntity> implements MarcaDAO {
	
	@Autowired
	private MarcaRepository repository;
	
	@Autowired
	private MarcaMapper mapper; 

	@Override
	protected JpaRepository<MarcaEntity, Long> getRepository() { 
		return repository;
	}

	@Override
	protected BaseMapperEntity<Marca, MarcaEntity> getDefaultMapper() {
		return mapper;
	}



}
