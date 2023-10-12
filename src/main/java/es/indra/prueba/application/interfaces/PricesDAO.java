package es.indra.prueba.application.interfaces;

import java.util.Date;
import java.util.List;

import es.indra.prueba.domain.Prices;

public interface PricesDAO {

	List<Prices> findByDateAndIdBrandAndIdProduct(Date fecha, Long idBrand, Long idProduct);
}
