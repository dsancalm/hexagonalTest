package es.indra.prueba.infraestructure.rest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.indra.prueba.application.common.exceptions.PricesServiceException;
import es.indra.prueba.application.interfaces.PricesService;
import es.indra.prueba.domain.Prices;
import es.indra.prueba.infraestructure.rest.api.PriceApi;
import es.indra.prueba.infraestructure.rest.mapper.PricesDtoMapper;
import es.indra.prueba.infraestructure.rest.model.PricesDto;

@RestController 
public class PricesController implements PriceApi {
	
	@Autowired
	private PricesService service;
	
	@Autowired
	private PricesDtoMapper mapper;
	
	//default time zone
	private ZoneId defaultZoneId = ZoneId.systemDefault();
	
	@Override
	public ResponseEntity<PricesDto> findPriceByDateBrandProduct(Integer idBrand, Integer idProduct,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {
		try {
			Prices price = this.service.recuperaPrecioMasPrioritario(Date.from(fecha.atZone(defaultZoneId).toInstant()), Long.valueOf(idBrand), Long.valueOf(idProduct));
			PricesDto priceDto = mapper.toDto(price);
			priceDto.setDate(fecha);
			return ResponseEntity.ok(priceDto); 
		} catch (PricesServiceException e) {
			if (e.getCause().getClass().equals(NoSuchElementException.class)) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.internalServerError().build();
		}
		

	}

}
