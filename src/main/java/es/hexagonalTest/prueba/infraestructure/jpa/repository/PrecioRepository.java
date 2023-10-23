package es.hexagonalTest.prueba.infraestructure.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.hexagonalTest.prueba.infraestructure.jpa.model.PrecioEntity;

@Repository
public interface PrecioRepository extends JpaRepository<PrecioEntity, Long> {
	
	@Override
	@EntityGraph(value = "PrecioEntity.Full", type = EntityGraph.EntityGraphType.LOAD)
	List<PrecioEntity> findAll();

}
