package es.hexagonalTest.prueba.infraestructure.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hexagonalTest.prueba.application.interfaces.PricesDAO;
import es.hexagonalTest.prueba.domain.Prices;
import es.hexagonalTest.prueba.infraestructure.jpa.mapper.PricesMapper;

@Service
public class PricesDAOImpl implements PricesDAO {
	
	@Autowired
	private PricesRepository pricesRepository;
	
	@Autowired
	private PricesMapper pricesMapper;

	/**
	 * Busca los precios filtrando por id de marca, id de producrto y una fecha
	 *
	 * @param fecha the fecha
	 * @param idBrand the id brand
	 * @param idProduct the id product
	 * @return the list
	 */
	@Override
	public List<Prices> findByDateAndIdBrandAndIdProduct(Date fecha, Long idBrand, Long idProduct) {
		return pricesMapper.toDomain(pricesRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrand_IdAndProduct_Id(fecha, fecha, idBrand, idProduct));
	}

}
