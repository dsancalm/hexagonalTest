package es.hexagonalTest.prueba.infraestructure.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "precios")
@Data
public class PrecioEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426976262354366454L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	private Date startDate;

	private Date endDate;

	private BigDecimal price;

	@ManyToOne(optional = false)
	@JoinColumn(name = "coches_id", nullable = false, updatable = false)
	private CocheEntity coche;
}
