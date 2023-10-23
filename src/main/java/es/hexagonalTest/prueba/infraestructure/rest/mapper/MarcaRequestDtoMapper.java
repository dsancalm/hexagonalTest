package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Marca;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperRequestDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.MarcaRequestDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MarcaRequestDtoMapper extends BaseMapperRequestDto<Marca, MarcaRequestDto> { 

	
	@Override
	@Mapping(source = "nombre", target = "nombreMarca")
	Marca dtoToDomain(MarcaRequestDto dto);
}
