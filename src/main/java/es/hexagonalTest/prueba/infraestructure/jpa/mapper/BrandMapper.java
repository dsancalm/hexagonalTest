package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Brand;
import es.hexagonalTest.prueba.infraestructure.jpa.model.BrandEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrandMapper {

	Brand toDomain(BrandEntity brand);
}
