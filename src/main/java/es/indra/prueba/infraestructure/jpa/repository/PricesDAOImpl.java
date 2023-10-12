package es.indra.prueba.infraestructure.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.indra.prueba.application.interfaces.PricesDAO;
import es.indra.prueba.domain.Prices;
import es.indra.prueba.infraestructure.jpa.mapper.PricesMapper;

@Service
public class PricesDAOImpl implements PricesDAO {
	
	@Autowired
	private PricesRepository pricesRepository;
	
	@Autowired
	private PricesMapper pricesMapper;

	@Override
	public List<Prices> findByDateAndIdBrandAndIdProduct(Date fecha, Long idBrand, Long idProduct) {
		return pricesMapper.toDomain(pricesRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrand_IdAndProduct_Id(fecha, fecha, idBrand, idProduct));
	}

}
