package es.hexagonalTest.prueba.domain;

import java.math.BigDecimal;
import java.util.Date;

import es.hexagonalTest.prueba.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Precio extends BaseDomain  {

	private Date startDate;
	
	private Date endDate;
	
	private BigDecimal price;
	
	private Coche coche;
}
