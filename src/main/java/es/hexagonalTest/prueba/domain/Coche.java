package es.hexagonalTest.prueba.domain;

import java.util.List;

import lombok.Data;

@Data
public class Coche {
	
	private Long id;
	
	private String nombreModelo;
	
	private String color;
	
	private int cilindrada;
	
	private int potencia;
	
	private List<Precio> precios;
	
	private List<Extra> extras;
	
	private Marca marca;

}
