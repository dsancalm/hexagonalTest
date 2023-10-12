package es.indra.prueba.application.interfaces;

import java.util.Date;

import es.indra.prueba.application.common.exceptions.PricesServiceException;
import es.indra.prueba.domain.Prices;

public interface PricesService {

	Prices recuperaPrecioMasPrioritario(Date fecha, Long idCadena, Long idProducto) throws PricesServiceException;
	
}
