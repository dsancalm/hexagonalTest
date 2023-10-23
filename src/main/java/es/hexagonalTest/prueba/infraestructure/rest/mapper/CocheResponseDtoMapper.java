package es.hexagonalTest.prueba.infraestructure.rest.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.hexagonalTest.prueba.domain.Coche;
import es.hexagonalTest.prueba.domain.Extra;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.base.BaseMapperResponseDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.CocheResponseDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PrecioResponseDtoMapper.class, MarcaResponseSimpleDtoMapper.class})
public interface CocheResponseDtoMapper extends BaseMapperResponseDto<Coche, CocheResponseDto> {
	
	@Override
	@Mapping(source = "nombreModelo", target = "modelo")
	CocheResponseDto domainToDto(Coche domain);
	
	default String map(List<Extra> value) {
		return value.stream().map(Extra::getNombre).collect(Collectors.joining(", "));

	}

}
