package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Extra;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.ExtraEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CocheMapperSimple.class} )
public interface ExtraMapper extends BaseMapperEntity<Extra, ExtraEntity> {

}
