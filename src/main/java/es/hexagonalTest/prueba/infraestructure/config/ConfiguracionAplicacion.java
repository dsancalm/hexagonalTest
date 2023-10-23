package es.hexagonalTest.prueba.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.hexagonalTest.prueba.application.impl.CocheServiceImpl;
import es.hexagonalTest.prueba.application.interfaces.CocheService;
import es.hexagonalTest.prueba.application.interfaces.dao.CocheDAO;

/**
 * Configuracion para inicializar la capa de aplicacion
 */
@Configuration
public class ConfiguracionAplicacion {

    @Bean
    CocheService cocheService(CocheDAO dao) {
		return new CocheServiceImpl(dao);
	}
}
