package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Extra;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperResponseDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.ExtraResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExtraResponseDtoMapper extends BaseMapperResponseDto<Extra, ExtraResponseDto> {
	

}
