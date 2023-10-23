package es.hexagonalTest.prueba.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.hexagonalTest.prueba.application.impl.CocheServiceImpl;
import es.hexagonalTest.prueba.application.impl.ExtraServiceImpl;
import es.hexagonalTest.prueba.application.impl.MarcaServiceImpl;
import es.hexagonalTest.prueba.application.impl.PrecioServiceImpl;
import es.hexagonalTest.prueba.application.interfaces.dao.CocheDAO;
import es.hexagonalTest.prueba.application.interfaces.dao.ExtraDAO;
import es.hexagonalTest.prueba.application.interfaces.dao.MarcaDAO;
import es.hexagonalTest.prueba.application.interfaces.dao.PrecioDAO;
import es.hexagonalTest.prueba.application.interfaces.services.CocheService;
import es.hexagonalTest.prueba.application.interfaces.services.ExtraService;
import es.hexagonalTest.prueba.application.interfaces.services.MarcaService;
import es.hexagonalTest.prueba.application.interfaces.services.PrecioService;

/**
 * Configuracion para inicializar la capa de aplicacion
 */
@Configuration
public class ConfiguracionAplicacion {

    @Bean
    CocheService cocheService(CocheDAO dao) {
		return new CocheServiceImpl(dao);
	}
    
    @Bean
    ExtraService extraService(ExtraDAO dao) {
		return new ExtraServiceImpl(dao);
	}
    
    @Bean
    MarcaService marcaService(MarcaDAO dao) {
		return new MarcaServiceImpl(dao);
	}
    
    @Bean
    PrecioService precioService(PrecioDAO dao) {
		return new PrecioServiceImpl(dao);
	}
}
