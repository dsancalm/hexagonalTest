package es.hexagonalTest.prueba.application.common.exceptions;

import es.hexagonalTest.prueba.application.interfaces.PricesService;
import lombok.experimental.StandardException;

/**
 * Excepcion para el servicio {@link PricesService}
 */
@StandardException
public class PricesServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3413389794713415178L;

}
