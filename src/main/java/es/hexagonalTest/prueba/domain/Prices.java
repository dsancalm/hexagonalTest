package es.hexagonalTest.prueba.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;


@Data
public class Prices {

    private Long id;

    private Brand brand;

    private Date startDate;

    private Date endDate;

    private Integer priceList;

    private Product product;

    private Integer priority;

    private BigDecimal price;

    private String curr;

}
