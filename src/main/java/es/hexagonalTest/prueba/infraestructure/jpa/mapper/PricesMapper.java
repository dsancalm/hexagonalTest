package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Prices;
import es.hexagonalTest.prueba.infraestructure.jpa.model.PricesEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { ProductMapper.class, BrandMapper.class })
public interface PricesMapper {
	
	Prices toDomain(PricesEntity prices);
	
	List<Prices> toDomain(List<PricesEntity> prices);
}
