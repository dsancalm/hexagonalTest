package es.hexagonalTest.prueba.infraestructure.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class ProductEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME") 
    private String nombre;

}
