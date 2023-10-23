package es.hexagonalTest.prueba.infraestructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.hexagonalTest.prueba.infraestructure.jpa.model.CocheEntity;

@Repository
public interface CocheRepository extends JpaRepository<CocheEntity, Long> {
	
    /*@EntityGraph(value = "PricesEntity.Full", type = EntityGraph.EntityGraphType.LOAD)
	List<PricesEntity> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrand_IdAndProduct_Id(Date fechaInicio,
			Date fechaFin, Long idBrand, Long idProduct);*/

}
