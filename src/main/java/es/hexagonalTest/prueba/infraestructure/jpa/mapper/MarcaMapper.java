package es.hexagonalTest.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import es.hexagonalTest.prueba.domain.Marca;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.base.BaseMapperEntity;
import es.hexagonalTest.prueba.infraestructure.jpa.model.MarcaEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MarcaMapper extends BaseMapperEntity<Marca, MarcaEntity> {

}
