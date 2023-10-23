package es.hexagonalTest.prueba.infraestructure.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.hexagonalTest.prueba.infraestructure.jpa.model.MarcaEntity;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> {
	
	@Override
	@EntityGraph(value = "MarcaEntity.Full", type = EntityGraph.EntityGraphType.LOAD)
	List<MarcaEntity> findAll();

}
