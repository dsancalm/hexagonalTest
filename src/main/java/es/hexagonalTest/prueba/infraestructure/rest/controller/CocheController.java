package es.hexagonalTest.prueba.infraestructure.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import es.hexagonalTest.prueba.infraestructure.rest.api.CochesApi;
import es.hexagonalTest.prueba.infraestructure.rest.model.CocheDto;

public class CocheController implements CochesApi {

	@Override
	public ResponseEntity<Void> deleteCoche(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CocheDto>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CocheDto>> insertCoche(@Valid CocheDto cocheDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CocheDto>> updateCoche(@Valid CocheDto cocheDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
