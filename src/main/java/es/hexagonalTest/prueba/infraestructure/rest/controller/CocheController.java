package es.hexagonalTest.prueba.infraestructure.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.hexagonalTest.prueba.application.interfaces.services.CocheService;
import es.hexagonalTest.prueba.infraestructure.rest.api.CochesApi;
import es.hexagonalTest.prueba.infraestructure.rest.mapper.CocheDtoMapper;
import es.hexagonalTest.prueba.infraestructure.rest.model.CocheDto;
@RestController
public class CocheController implements CochesApi {
	
	@Autowired
	private CocheService service;
	
	@Autowired
	private CocheDtoMapper mapper;

	@Override
	public ResponseEntity<Void> deleteCoche(Integer id) {
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<CocheDto>> findAll() {
		try {
			return ResponseEntity.ok(mapper.domainToDtos(service.findAll())); 
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	public ResponseEntity<CocheDto> insertCoche(@Valid CocheDto cocheDto) {
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<CocheDto> updateCoche(@Valid CocheDto cocheDto) {
		return ResponseEntity.ok().build();
	}

}
