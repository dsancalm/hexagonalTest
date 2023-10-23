package es.hexagonalTest.prueba.infraestructure.jpa.model;

import java.io.Serializable;

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
@Table(name = "extras")
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "coches_id", nullable = false, updatable = false, insertable = false)
	private CocheEntity coche;

}
