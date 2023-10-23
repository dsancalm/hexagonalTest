package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Precio;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperResponseDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.PrecioResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrecioResponseSimpleDtoMapper extends BaseMapperResponseDto<Precio, PrecioResponseDto> {
	
	@Override
	@Mapping(source = "price", target = "precio")
	PrecioResponseDto domainToDto(Precio domain);

}
