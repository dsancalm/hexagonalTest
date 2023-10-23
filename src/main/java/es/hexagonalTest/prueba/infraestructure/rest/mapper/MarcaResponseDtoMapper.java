package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Marca;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperResponseDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.MarcaResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CocheResponseDtoMapper.class)
public interface MarcaResponseDtoMapper extends BaseMapperResponseDto<Marca, MarcaResponseDto> {
	
	@Override
	@Mapping(source = "nombreMarca", target = "nombre")
	MarcaResponseDto domainToDto(Marca domain);

}
