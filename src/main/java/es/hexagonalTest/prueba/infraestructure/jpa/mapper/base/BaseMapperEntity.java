package es.hexagonalTest.prueba.infraestructure.jpa.mapper.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface BaseMapperEntity<E, D extends Serializable> {

	D domainToEntity(E domain);

	E entityToDomain(D entity);

	default List<D> domainToEntities(List<E> domains) {
		return Optional.ofNullable(domains).map(Collection::stream).orElseGet(Stream::empty).map(this::domainToEntity)
				.collect(Collectors.toList());
	}

	default List<E> entitiesToDomains(List<D> entities) {
		return Optional.ofNullable(entities).map(Collection::stream).orElseGet(Stream::empty).map(this::entityToDomain)
				.collect(Collectors.toList());
	}

}
