package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Coche;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperRequestDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.CocheRequestDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CocheRequestDtoMapper extends BaseMapperRequestDto<Coche, CocheRequestDto> {

	@Override
	@Mapping(source = "modelo", target = "nombreModelo")
	@Mapping(target = "extras", ignore = true)
	@Mapping(target = "precios", ignore = true)
	Coche dtoToDomain(CocheRequestDto dto);
}
