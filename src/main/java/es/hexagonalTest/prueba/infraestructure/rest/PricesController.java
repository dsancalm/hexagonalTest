package es.hexagonalTest.prueba.infraestructure.rest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.hexagonalTest.prueba.application.common.exceptions.PricesServiceException;
import es.hexagonalTest.prueba.application.interfaces.PricesService;
import es.hexagonalTest.prueba.domain.Prices;
import es.hexagonalTest.prueba.infraestructure.rest.api.PriceApi;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.PricesDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.model.PricesDto;

@RestController 
public class PricesController implements PriceApi {
	
	@Autowired
	private PricesService service;
	
	@Autowired
	private PricesDtoMapper mapper;
	
	//default time zone
	private ZoneId defaultZoneId = ZoneId.systemDefault();
	
    /**
     * GET /price : Recupera el precio
     * Recupera el precio del producto dada una fecha, un identificador de marca y un identificador de producto
     *
     * @param idBrand Id de la marca a buscar el precio (required)
     * @param idProduct Id del producto a buscar (required)
     * @param fecha Fecha (required)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     *         or Not found (status code 404)
     *         or Internal server error (status code 500)
     */
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
