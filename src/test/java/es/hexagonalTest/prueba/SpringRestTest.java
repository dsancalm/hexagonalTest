package es.hexagonalTest.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import es.hexagonalTest.prueba.infraestructure.PruebaApplication;
import es.hexagonalTest.prueba.infraestructure.rest.model.CocheResponseDto;

@SpringBootTest(classes = PruebaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringRestTest {  

	private final String BASE_URL = "http://localhost:8080/";

	private RestTemplate restTemplate = new RestTemplate();


	@Test
	@Order(1)
	void testUno() {
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(BASE_URL).path("coches").encode().toUriString();
		ResponseEntity<CocheResponseDto[]> response = restTemplate.getForEntity(urlTemplate, CocheResponseDto[].class);
		assertEquals("AMG", response.getBody()[0].getModelo());
	}
	
	@Test
	@Order(2)
	void testDos() {
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(BASE_URL).path("coches").encode().toUriString();
		ResponseEntity<CocheResponseDto[]> response = restTemplate.getForEntity(urlTemplate, CocheResponseDto[].class);
		response.getBody()[0].setModelo("AAA");
		restTemplate.put(urlTemplate, response.getBody()[0]);
		response = restTemplate.getForEntity(urlTemplate, CocheResponseDto[].class);
		assertEquals("AAA", response.getBody()[0].getModelo());
	}

}
