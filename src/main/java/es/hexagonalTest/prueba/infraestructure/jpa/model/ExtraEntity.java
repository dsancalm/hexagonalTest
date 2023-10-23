package es.hexagonalTest.prueba.infraestructure.jpa.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "EXTRAS")
@NamedEntityGraphs(value = { 
		@NamedEntityGraph(name = "ExtraEntity.Full", attributeNodes = {@NamedAttributeNode("coche")}) 
	})
@Data
public class ExtraEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7692078370311362837L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "COCHES_ID", nullable = false, updatable = false, insertable = true)
	private CocheEntity coche;

}
