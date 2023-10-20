package es.hexagonalTest.prueba.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Precio {

	private Date startDate;
	
	private Date endDate;
	
	private BigDecimal price;
}
