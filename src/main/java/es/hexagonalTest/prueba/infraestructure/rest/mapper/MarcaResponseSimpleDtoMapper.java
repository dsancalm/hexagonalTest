package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Marca;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperResponseDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.MarcaResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MarcaResponseSimpleDtoMapper extends BaseMapperResponseDto<Marca, MarcaResponseDto> {
	
	@Override
	@Mapping(source = "nombreMarca", target = "nombre")
	@Mapping(target = "coches", ignore = true)
	MarcaResponseDto domainToDto(Marca domain);

}
