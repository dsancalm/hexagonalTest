package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Coche;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.CocheDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CocheDtoMapper extends BaseMapperDto<Coche, CocheDto> {

}
