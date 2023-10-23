package es.hexagonalTest.prueba.infraestructure.rest.mapper.base;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface BaseMapperDto<E, D> {

	D domainToDto(E domain);

	E dtoToDomain(D dto);

	default List<D> domainToEntities(List<E> domains) {
		return Optional.ofNullable(domains).map(Collection::stream).orElseGet(Stream::empty).map(this::domainToDto)
				.collect(Collectors.toList());
	}

	default List<E> entitiesToDomains(List<D> entities) {
		return Optional.ofNullable(entities).map(Collection::stream).orElseGet(Stream::empty).map(this::dtoToDomain)
				.collect(Collectors.toList());
	}

}
