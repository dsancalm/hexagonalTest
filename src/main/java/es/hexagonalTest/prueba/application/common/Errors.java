package es.hexagonalTest.prueba.application.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Conjunto de errores que puede devolver la capa APP
 */
@AllArgsConstructor
@Getter
public enum Errors {

	ERROR_SAVE("error.save"), ERROR_UPDATE("error.update"), ERROR_DELETE("error.delete"),
	ERROR_NOT_FOUND("error.not.found"), ERROR_GENERIC("error.generic");

	private String code;

}
