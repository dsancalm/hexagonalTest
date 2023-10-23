package es.hexagonalTest.prueba.infraestructure.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.hexagonalTest.prueba.application.common.Errors;
import es.hexagonalTest.prueba.application.common.responses.ResponseService;
import es.hexagonalTest.prueba.application.interfaces.services.PrecioService;
import es.hexagonalTest.prueba.domain.Precio;
import es.hexagonalTest.prueba.infraestructure.rest.api.PreciosApi;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.PrecioRequestDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.PrecioResponseDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.model.PrecioRequestDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.PrecioResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@SecurityRequirement(name = "basicAuth")
public class PrecioController implements PreciosApi {
	
	private static final String ERROR_CODE = "errorCode";

	@Autowired
	private PrecioService service;
	
	@Autowired
	private PrecioRequestDtoMapper mapperRequest;
	
	@Autowired
	private PrecioResponseDtoMapper mapperResponse;

	@Override
	public ResponseEntity<Void> deletePrecio(Integer id) {
		Precio precio = new Precio();
		precio.setId(Long.valueOf(id));
		ResponseService<Precio> respuestaServicio = service.remove(precio);
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<PrecioResponseDto>> findAllPrecios() {
		ResponseService<Precio> respuestaServicio = service.findAll();
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		final List<PrecioResponseDto> resultadoServicio = mapperResponse.domainToDtos(respuestaServicio.getListData());
		return ResponseEntity.ok(resultadoServicio);

	}

	@Override
	public ResponseEntity<PrecioResponseDto> insertPrecio(@Valid PrecioRequestDto precioDto) {
		final ResponseService<Precio> respuestaServicio = service.save(mapperRequest.dtoToDomain(precioDto));
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok(mapperResponse.domainToDto(respuestaServicio.getData()));

	}

	@Override
	public ResponseEntity<PrecioResponseDto> updatePrecio(@Valid PrecioRequestDto precioDto) {
		final ResponseService<Precio> respuestaServicio = service.update(mapperRequest.dtoToDomain(precioDto));
		if (respuestaServicio.hasError()) {
			if (respuestaServicio.getErrorCode().equals(Errors.ERROR_NOT_FOUND)) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok(mapperResponse.domainToDto(respuestaServicio.getData()));
	}

}
