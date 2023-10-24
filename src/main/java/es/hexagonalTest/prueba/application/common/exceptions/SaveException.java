package es.hexagonalTest.prueba.application.common.exceptions;

import lombok.experimental.StandardException;

/**
 * Excepcion cuando el DAO no puede guardar
 */
@StandardException
public class SaveException extends DaoException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2599664201055594332L;
	

}
