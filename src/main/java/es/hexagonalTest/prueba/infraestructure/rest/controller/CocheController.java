package es.hexagonalTest.prueba.infraestructure.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.hexagonalTest.prueba.application.common.responses.ResponseService;
import es.hexagonalTest.prueba.application.interfaces.services.CocheService;
import es.hexagonalTest.prueba.domain.Coche;
import es.hexagonalTest.prueba.infraestructure.rest.api.CochesApi;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.CocheRequestDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.CocheResponseDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.model.CocheRequestDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.CocheResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@SecurityRequirement(name = "basicAuth")
public class CocheController implements CochesApi {
	
	private static final String ERROR_CODE = "errorCode";

	@Autowired
	private CocheService service;
	
	@Autowired
	private CocheRequestDtoMapper mapperRequest;
	
	@Autowired
	private CocheResponseDtoMapper mapperResponse;

	@Override
	public ResponseEntity<Void> deleteCoche(Integer id) {
		Coche coche = new Coche();
		coche.setId(Long.valueOf(id));
		ResponseService<Coche> respuestaServicio = service.remove(coche);
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<CocheResponseDto>> findAllCoches() {
		ResponseService<Coche> respuestaServicio = service.findAll();
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		final List<CocheResponseDto> resultadoServicio = mapperResponse.domainToDtos(respuestaServicio.getListData());
		return ResponseEntity.ok(resultadoServicio);

	}

	@Override
	public ResponseEntity<CocheResponseDto> insertCoche(@Valid CocheRequestDto cocheDto) {
		final ResponseService<Coche> respuestaServicio = service.save(mapperRequest.dtoToDomain(cocheDto));
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok(mapperResponse.domainToDto(respuestaServicio.getData()));

	}

	@Override
	public ResponseEntity<CocheResponseDto> updateCoche(@Valid CocheRequestDto cocheDto) {
		final ResponseService<Coche> respuestaServicio = service.update(mapperRequest.dtoToDomain(cocheDto));
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok(mapperResponse.domainToDto(respuestaServicio.getData()));
	}

}
