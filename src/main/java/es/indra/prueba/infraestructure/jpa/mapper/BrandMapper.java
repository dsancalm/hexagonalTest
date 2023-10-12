package es.indra.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.indra.prueba.domain.Brand;
import es.indra.prueba.infraestructure.jpa.model.BrandEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BrandMapper {

	Brand toDomain(BrandEntity brand);
}
