package es.hexagonalTest.prueba.infraestructure.rest.mapper.base;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface BaseMapperDto<E, D> {

	D domainToDto(E domain);

	E dtoToDomain(D dto);

	default List<D> domainToDtos(List<E> domains) {
		return Optional.ofNullable(domains).map(Collection::stream).orElseGet(Stream::empty).map(this::domainToDto)
				.collect(Collectors.toList());
	}

	default List<E> dtosToDomains(List<D> dtos) {
		return Optional.ofNullable(dtos).map(Collection::stream).orElseGet(Stream::empty).map(this::dtoToDomain)
				.collect(Collectors.toList());
	}

}
