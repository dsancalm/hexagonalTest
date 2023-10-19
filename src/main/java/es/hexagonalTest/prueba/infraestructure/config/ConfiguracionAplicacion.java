package es.hexagonalTest.prueba.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.hexagonalTest.prueba.application.impl.PricesServiceImpl;
import es.hexagonalTest.prueba.application.interfaces.PricesDAO;
import es.hexagonalTest.prueba.application.interfaces.PricesService;

/**
 * Configuracion para inicializar la capa de aplicacion
 */
@Configuration
public class ConfiguracionAplicacion {

    @Bean
    PricesService userService(PricesDAO dao) {
		return new PricesServiceImpl(dao);
	}
}
