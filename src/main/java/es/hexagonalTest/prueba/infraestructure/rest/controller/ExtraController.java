package es.hexagonalTest.prueba.infraestructure.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.hexagonalTest.prueba.application.common.Errors;
import es.hexagonalTest.prueba.application.common.responses.ResponseService;
import es.hexagonalTest.prueba.application.interfaces.services.ExtraService;
import es.hexagonalTest.prueba.domain.Extra;
import es.hexagonalTest.prueba.infraestructure.rest.api.ExtrasApi;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.ExtraRequestDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.ExtraResponseDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.model.ExtraRequestDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.ExtraResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@SecurityRequirement(name = "basicAuth")
public class ExtraController implements ExtrasApi {
	
	private static final String ERROR_CODE = "errorCode";

	@Autowired
	private ExtraService service;
	
	@Autowired
	private ExtraRequestDtoMapper mapperRequest; 
	
	@Autowired
	private ExtraResponseDtoMapper mapperResponse;

	@Override
	public ResponseEntity<Void> deleteExtra(Integer id) {
		Extra precio = new Extra();
		precio.setId(Long.valueOf(id));
		ResponseService<Extra> respuestaServicio = service.remove(precio);
		if (respuestaServicio.hasError()) {
			if (respuestaServicio.getErrorCode().equals(Errors.ERROR_NOT_FOUND)) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<ExtraResponseDto>> findAllExtras() {
		ResponseService<Extra> respuestaServicio = service.findAll();
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		final List<ExtraResponseDto> resultadoServicio = mapperResponse.domainToDtos(respuestaServicio.getListData());
		return ResponseEntity.ok(resultadoServicio);

	}

	@Override
	public ResponseEntity<ExtraResponseDto> insertExtra(@Valid ExtraRequestDto precioDto) {
		final ResponseService<Extra> respuestaServicio = service.save(mapperRequest.dtoToDomain(precioDto));
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok(mapperResponse.domainToDto(respuestaServicio.getData()));

	}

	@Override
	public ResponseEntity<ExtraResponseDto> updateExtra(@Valid ExtraRequestDto precioDto) {
		final ResponseService<Extra> respuestaServicio = service.update(mapperRequest.dtoToDomain(precioDto));
		if (respuestaServicio.hasError()) {
			if (respuestaServicio.getErrorCode().equals(Errors.ERROR_NOT_FOUND)) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok(mapperResponse.domainToDto(respuestaServicio.getData()));
	}

}
