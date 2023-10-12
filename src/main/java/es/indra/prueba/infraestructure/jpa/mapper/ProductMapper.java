package es.indra.prueba.infraestructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import es.indra.prueba.domain.Product;
import es.indra.prueba.infraestructure.jpa.model.ProductEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
	
	Product toDomain(ProductEntity product);
}
