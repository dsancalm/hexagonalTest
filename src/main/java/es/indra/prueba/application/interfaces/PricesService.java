package es.indra.prueba.application.interfaces;

import java.util.Date;

import es.indra.prueba.application.common.exceptions.PricesServiceException;
import es.indra.prueba.domain.Prices;

/**
 * Interfaz del servicio
 */
public interface PricesService {

	/**
	 * Recupera una lista de precios dado un id de producto, de cadena y una fecha.
	 * De la lista recuperada devuelve el precio con mayor prioridad
	 *
	 * @param fecha      the fecha
	 * @param idCadena   the id cadena
	 * @param idProducto the id producto
	 * @return El precio mas prioritario o el unico recuperado
	 * @throws PricesServiceException Si no recupera ningun tipo de precio
	 */
	Prices recuperaPrecioMasPrioritario(Date fecha, Long idCadena, Long idProducto) throws PricesServiceException;
	
}
