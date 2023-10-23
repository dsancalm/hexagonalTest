package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Precio;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperRequestDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.PrecioRequestDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CocheRequestDtoMapper.class)
public interface PrecioRequestDtoMapper extends BaseMapperRequestDto<Precio, PrecioRequestDto> { 
	
	
	@Override
	@Mapping(source = "precio", target = "price")
	Precio dtoToDomain(PrecioRequestDto dto);
	
}
