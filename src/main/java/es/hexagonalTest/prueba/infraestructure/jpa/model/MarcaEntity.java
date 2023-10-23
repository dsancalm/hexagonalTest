package es.hexagonalTest.prueba.infraestructure.jpa.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "marcas")
@NamedEntityGraphs(value = { 
		@NamedEntityGraph(name = "MarcaEntity.Full", attributeNodes = {@NamedAttributeNode("coches")}) 
	})
@Data
public class MarcaEntity implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7077707091364322025L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	
	@Column(name = "NOMBRE_MARCA")
	private String nombreMarca;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca", orphanRemoval = true)
	private List<CocheEntity> coches;

}
