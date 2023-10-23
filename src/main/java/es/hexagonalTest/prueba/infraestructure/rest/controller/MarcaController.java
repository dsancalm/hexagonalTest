package es.hexagonalTest.prueba.infraestructure.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.hexagonalTest.prueba.application.common.Errors;
import es.hexagonalTest.prueba.application.common.responses.ResponseService;
import es.hexagonalTest.prueba.application.interfaces.services.MarcaService;
import es.hexagonalTest.prueba.domain.Marca;
import es.hexagonalTest.prueba.infraestructure.rest.api.MarcasApi;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.MarcaRequestDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.MarcaResponseDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.model.MarcaRequestDto;
import es.hexagonalTest.prueba.infraestructure.rest.model.MarcaResponseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@SecurityRequirement(name = "basicAuth")
public class MarcaController implements MarcasApi {
	
	private static final String ERROR_CODE = "errorCode";

	@Autowired
	private MarcaService service;
	
	@Autowired
	private MarcaRequestDtoMapper mapperRequest; 
	
	@Autowired
	private MarcaResponseDtoMapper mapperResponse;

	@Override
	public ResponseEntity<Void> deleteMarca(Integer id) {
		Marca precio = new Marca();
		precio.setId(Long.valueOf(id));
		ResponseService<Marca> respuestaServicio = service.remove(precio);
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<MarcaResponseDto>> findAllMarcas() {
		ResponseService<Marca> respuestaServicio = service.findAll();
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		final List<MarcaResponseDto> resultadoServicio = mapperResponse.domainToDtos(respuestaServicio.getListData());
		return ResponseEntity.ok(resultadoServicio);

	}

	@Override
	public ResponseEntity<MarcaResponseDto> insertMarca(@Valid MarcaRequestDto precioDto) {
		final ResponseService<Marca> respuestaServicio = service.save(mapperRequest.dtoToDomain(precioDto));
		if (respuestaServicio.hasError()) {
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok(mapperResponse.domainToDto(respuestaServicio.getData()));

	}

	@Override
	public ResponseEntity<MarcaResponseDto> updateMarca(@Valid MarcaRequestDto precioDto) {
		final ResponseService<Marca> respuestaServicio = service.update(mapperRequest.dtoToDomain(precioDto));
		if (respuestaServicio.hasError()) {
			if (respuestaServicio.getErrorCode().equals(Errors.ERROR_NOT_FOUND)) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.internalServerError().header(ERROR_CODE, respuestaServicio.getErrorCode().getCode()).build();
		}
		return ResponseEntity.ok(mapperResponse.domainToDto(respuestaServicio.getData()));
	}

}
