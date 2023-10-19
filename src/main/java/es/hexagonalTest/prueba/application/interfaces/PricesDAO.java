/*
 * 
 */
package es.hexagonalTest.prueba.application.interfaces;

import java.util.Date;
import java.util.List;

import es.hexagonalTest.prueba.domain.Prices;

/**
 * The Interface PricesDAO.
 */
public interface PricesDAO {

	/**
	 * Busca los precios filtrando por id de marca, id de producrto y una fecha
	 *
	 * @param fecha the fecha
	 * @param idBrand the id brand
	 * @param idProduct the id product
	 * @return the list
	 */
	List<Prices> findByDateAndIdBrandAndIdProduct(Date fecha, Long idBrand, Long idProduct);
}
