package es.hexagonalTest.prueba.infraestructure.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.hexagonalTest.prueba.infraestructure.jpa.model.ExtraEntity;

@Repository
public interface ExtraRepository extends JpaRepository<ExtraEntity, Long> {

	@Override
	@EntityGraph(value = "ExtraEntity.Full", type = EntityGraph.EntityGraphType.LOAD)
	List<ExtraEntity> findAll();
}
