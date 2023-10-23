package es.hexagonalTest.prueba.domain;

import java.util.List;

import lombok.Data;

@Data
public class Marca {
	
	private Long id;
	
	private String nombreMarca;
	
	private List<Coche> coches;

}
