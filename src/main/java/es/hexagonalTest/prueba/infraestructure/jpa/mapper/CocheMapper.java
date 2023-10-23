package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Coche;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.CocheEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { PrecioMapperSimple.class, ExtraMapperSimple.class,
		MarcaMapperSimple.class })
public interface CocheMapper extends BaseMapperEntity<Coche, CocheEntity> {

}
