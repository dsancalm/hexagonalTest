package es.hexagonalTest.prueba.domain;

import java.util.List;

import es.hexagonalTest.prueba.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Marca extends BaseDomain  {
	
	private String nombreMarca;
	
	private List<Coche> coches;

}
