package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Coche;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.CocheEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CocheMapperSimple extends BaseMapperEntity<Coche, CocheEntity> {
	
	@Mapping(target = "precios", ignore = true)
	@Mapping(target = "extras", ignore = true)
	@Mapping(target = "marca", ignore = true)
	@Override
	CocheEntity domainToEntity(Coche domain);
	
	@Mapping(target = "precios", ignore = true)
	@Mapping(target = "extras", ignore = true)
	@Mapping(target = "marca", ignore = true)
	@Override
	Coche entityToDomain(CocheEntity entity);

}
