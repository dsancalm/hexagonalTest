package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Precio;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.PrecioEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrecioMapperSimple extends BaseMapperEntity<Precio, PrecioEntity> {
	
	
	@Mapping(target = "coche", ignore = true)
	@Override
	PrecioEntity domainToEntity(Precio domain);
	
	
	@Mapping(target = "coche", ignore = true)
	@Override
	Precio entityToDomain(PrecioEntity entity);

}
