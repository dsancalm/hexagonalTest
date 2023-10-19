package es.hexagonalTest.prueba.infraestructure.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import es.hexagonalTest.prueba.infraestructure.jpa.model.PricesEntity;

public interface PricesRepository extends JpaRepository<PricesEntity, Long> {
	
    @EntityGraph(value = "PricesEntity.Full", type = EntityGraph.EntityGraphType.LOAD)
	List<PricesEntity> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrand_IdAndProduct_Id(Date fechaInicio,
			Date fechaFin, Long idBrand, Long idProduct);

}
