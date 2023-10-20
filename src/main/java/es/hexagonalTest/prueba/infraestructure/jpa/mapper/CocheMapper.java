package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import es.hexagonalTest.prueba.domain.Coche;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.CocheEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { PrecioMapper.class, ExtraMapper.class,
		MarcaMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CocheMapper extends BaseMapperEntity<Coche, CocheEntity> {

}
