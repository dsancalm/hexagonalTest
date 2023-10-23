package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Extra;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperRequestDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.ExtraRequestDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CocheRequestDtoMapper.class)
public interface ExtraRequestDtoMapper extends BaseMapperRequestDto<Extra, ExtraRequestDto> { 
	
	
}
