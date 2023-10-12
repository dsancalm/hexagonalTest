package es.indra.prueba.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.indra.prueba.application.impl.PricesServiceImpl;
import es.indra.prueba.application.interfaces.PricesDAO;
import es.indra.prueba.application.interfaces.PricesService;

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
