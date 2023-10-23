package es.hexagonalTest.prueba.application.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Errors {

	ERROR_SAVE("error.save"), ERROR_UPDATE("error.update"), ERROR_DELETE("error.delete"),
	ERROR_GENERIC("error.generic");

	private String code;

}
