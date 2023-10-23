package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Marca;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.MarcaEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MarcaMapperSimple extends BaseMapperEntity<Marca, MarcaEntity> {
	
	@Mapping(target = "coches", ignore = true)
	@Override
	MarcaEntity domainToEntity(Marca domain);
	
	@Mapping(target = "coches", ignore = true)
	@Override
	Marca entityToDomain(MarcaEntity entity);

}
