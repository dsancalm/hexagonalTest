package es.hexagonalTest.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import es.hexagonalTest.prueba.infraestructure.PruebaApplication;
import es.hexagonalTest.prueba.infraestructure.rest.model.PricesDto;

@SpringBootTest(classes = PruebaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringRestTest {

	private final String BASE_URL = "http://localhost:8080/price";

	private final String urlTemplate = UriComponentsBuilder.fromHttpUrl(BASE_URL).queryParam("idBrand", "{idBrand}")
			.queryParam("idProduct", "{idProduct}").queryParam("fecha", "{fecha}").encode().toUriString();

	private RestTemplate restTemplate = new RestTemplate();

	private Map<String, Object> params;

	@BeforeEach
	public void generarMapa() {
		params = new HashMap<String, Object>();
		params.put("idBrand", 1);
		params.put("idProduct", 35455);
	}

	@Test
	void testUno() {
		params.put("fecha", "2020-06-14T10:00:00");
		ResponseEntity<PricesDto> response = restTemplate.getForEntity(urlTemplate, PricesDto.class, params);
		assertEquals(35.5f, response.getBody().getFinalPrice());
	}

	@Test
	void testDos() {
		params.put("fecha", "2020-06-14T16:00:00");
		ResponseEntity<PricesDto> response = restTemplate.getForEntity(urlTemplate, PricesDto.class, params);
		assertEquals(25.45f, response.getBody().getFinalPrice());
	}

	@Test
	void testTres() {
		params.put("fecha", "2020-06-14T21:00:00");
		ResponseEntity<PricesDto> response = restTemplate.getForEntity(urlTemplate, PricesDto.class, params);
		assertEquals(35.5f, response.getBody().getFinalPrice());
	}

	@Test
	void testCuatro() {
		params.put("fecha", "2020-06-15T10:00:00");
		ResponseEntity<PricesDto> response = restTemplate.getForEntity(urlTemplate, PricesDto.class, params);
		assertEquals(30.50f, response.getBody().getFinalPrice());
	}

	@Test
	void testCinco() {
		params.put("fecha", "2020-06-15T21:00:00");
		ResponseEntity<PricesDto> response = restTemplate.getForEntity(urlTemplate, PricesDto.class, params);
		assertEquals(38.95f, response.getBody().getFinalPrice());
	}

}
