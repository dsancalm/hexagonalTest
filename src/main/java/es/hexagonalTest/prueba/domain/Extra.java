package es.hexagonalTest.prueba.domain;

import es.hexagonalTest.prueba.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Extra extends BaseDomain {
	
	private String nombre;
	
	private Coche coche;

}
