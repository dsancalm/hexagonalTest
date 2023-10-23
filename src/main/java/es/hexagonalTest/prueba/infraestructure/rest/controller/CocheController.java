package es.hexagonalTest.prueba.infraestructure.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.hexagonalTest.prueba.application.common.exceptions.ServiceException;
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
		try {
			service.remove(coche);
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<CocheResponseDto>> findAll() {
		try {
			return ResponseEntity.ok(mapperResponse.domainToDtos(service.findAll())); 
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	public ResponseEntity<CocheResponseDto> insertCoche(@Valid CocheRequestDto cocheDto) {
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<CocheResponseDto> updateCoche(@Valid CocheRequestDto cocheDto) {
		return ResponseEntity.ok().build();
	}

}
