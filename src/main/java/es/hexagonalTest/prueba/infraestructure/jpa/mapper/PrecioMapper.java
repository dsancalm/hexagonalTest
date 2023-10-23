package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Precio;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.PrecioEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CocheMapperSimple.class})
public interface PrecioMapper extends BaseMapperEntity<Precio, PrecioEntity> {

}
