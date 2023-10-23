package es.hexagonalTest.prueba.domain;

import java.util.List;

import es.hexagonalTest.prueba.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Coche extends BaseDomain {
	
	private String nombreModelo;
	
	private String color;
	
	private int cilindrada;
	
	private int potencia;
	
	private List<Precio> precios;
	
	private List<Extra> extras;
	
	private Marca marca;

}
