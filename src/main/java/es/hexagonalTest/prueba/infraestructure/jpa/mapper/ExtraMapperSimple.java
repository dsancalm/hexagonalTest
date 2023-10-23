package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Extra;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.ExtraEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExtraMapperSimple extends BaseMapperEntity<Extra, ExtraEntity> {

	@Mapping(target = "coche", ignore = true)
	@Override
	Extra entityToDomain(ExtraEntity entity);
	
	@Mapping(target = "coche", ignore = true)
	@Override
	ExtraEntity domainToEntity(Extra domain);
}
