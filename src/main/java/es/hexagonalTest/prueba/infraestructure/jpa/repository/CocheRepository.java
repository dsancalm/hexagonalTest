package es.hexagonalTest.prueba.infraestructure.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.hexagonalTest.prueba.infraestructure.jpa.model.CocheEntity;

@Repository
public interface CocheRepository extends JpaRepository<CocheEntity, Long> {

	@Override
	@EntityGraph(value = "CocheEntity.Full", type = EntityGraph.EntityGraphType.LOAD)
	List<CocheEntity> findAll();
}
