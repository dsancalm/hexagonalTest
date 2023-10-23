package es.hexagonalTest.prueba.infraestructure.jpa.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "coches")
@Data
public class CocheEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6431630117545879949L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	private String nombreModelo;

	private String color;

	private int cilindrada;

	private int potencia;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coche", orphanRemoval = true)
	private List<PrecioEntity> precios;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coche", orphanRemoval = true)
	private List<ExtraEntity> extras;

	@ManyToOne(optional = false)
	@JoinColumn(name = "marca_id", nullable = false, updatable = false, insertable = false)
	private MarcaEntity marca;

}
