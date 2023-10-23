package es.hexagonalTest.prueba.infraestructure.rest.mapper.base;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface BaseMapperRequestDto<E, D> {

	E dtoToDomain(D dto);

	default List<E> dtosToDomains(List<D> dtos) {
		return Optional.ofNullable(dtos).map(Collection::stream).orElseGet(Stream::empty).map(this::dtoToDomain)
				.collect(Collectors.toList());
	}

}
