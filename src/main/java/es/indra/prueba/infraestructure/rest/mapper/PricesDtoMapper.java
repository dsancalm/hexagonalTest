package es.indra.prueba.infraestructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import es.indra.prueba.domain.Prices;
import es.indra.prueba.infraestructure.rest.model.PricesDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PricesDtoMapper {
	
	@Mapping(source = "brand.id", target = "idBrand")
	@Mapping(source = "product.id", target = "idProduct")
	@Mapping(source = "price", target = "finalPrice")
	@Mapping(source = "priceList", target = "fee")
	PricesDto toDto(Prices prices);
}
