package es.hexagonalTest.prueba.application.common.responses;

import java.util.List;
import java.util.Objects;

import es.hexagonalTest.prueba.application.common.Errors;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase generica para la respuesta de la capa APP
 *
 * @param <T> the generic type
 */
@Data
@NoArgsConstructor
public class ResponseService<T> {
	private Errors errorCode;
	private T data;
	private List<T> listData;
	public boolean hasError() {
		return Objects.nonNull(errorCode);
	}
	
	public ResponseService(Errors errorCode) {
		super();
		this.errorCode = errorCode;
	}
}
