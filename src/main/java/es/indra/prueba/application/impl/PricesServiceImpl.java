
package es.indra.prueba.application.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import es.indra.prueba.application.common.exceptions.PricesServiceException;
import es.indra.prueba.application.interfaces.PricesDAO;
import es.indra.prueba.application.interfaces.PricesService;
import es.indra.prueba.domain.Prices;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * The Class PricesServiceImpl.
 */
@RequiredArgsConstructor
@Slf4j
public class PricesServiceImpl implements PricesService {
	
	/** The price DAO. */
	@NonNull
	private final PricesDAO priceDAO;

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
	@Override
	public Prices recuperaPrecioMasPrioritario(Date fecha, Long idCadena, Long idProducto) throws PricesServiceException {
		log.info(String.format("Recuperando precio con los argumentos: %tc %d %d", fecha, idCadena, idProducto));
		List<Prices> precios = priceDAO.findByDateAndIdBrandAndIdProduct(fecha, idCadena, idProducto);
		try {
			return precios.stream().max((a, b) -> a.getPriority().compareTo(b.getPriority())).orElseThrow();
		} catch (NoSuchElementException e) {
			log.warn("No se ha encontrado ningun precio");
			throw new PricesServiceException("No se ha encontrado ningun precio", e);
		}
	}

}
