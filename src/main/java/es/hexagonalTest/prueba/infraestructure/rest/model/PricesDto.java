package es.hexagonalTest.prueba.infraestructure.rest.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

/**
 * PricesDto
 */

@JsonTypeName("Prices")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-12T10:37:29.962692900+02:00[Europe/Madrid]")
public class PricesDto {

  @JsonProperty("idProduct")
  private Integer idProduct;

  @JsonProperty("idBrand")
  private Integer idBrand;

  @JsonProperty("fee")
  private Integer fee;

  @JsonProperty("date")
  private LocalDateTime date;

  @JsonProperty("finalPrice")
  private Float finalPrice;

  public PricesDto idProduct(Integer idProduct) {
    this.idProduct = idProduct;
    return this;
  }

  /**
   * Get idProduct
   * @return idProduct
  */
  
  @Schema(name = "idProduct", required = false)
  public Integer getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(Integer idProduct) {
    this.idProduct = idProduct;
  }

  public PricesDto idBrand(Integer idBrand) {
    this.idBrand = idBrand;
    return this;
  }

  /**
   * Get idBrand
   * @return idBrand
  */
  
  @Schema(name = "idBrand", required = false)
  public Integer getIdBrand() {
    return idBrand;
  }

  public void setIdBrand(Integer idBrand) {
    this.idBrand = idBrand;
  }

  public PricesDto fee(Integer fee) {
    this.fee = fee;
    return this;
  }

  /**
   * Get fee
   * @return fee
  */
  
  @Schema(name = "fee", required = false)
  public Integer getFee() {
    return fee;
  }

  public void setFee(Integer fee) {
    this.fee = fee;
  }

  public PricesDto date(LocalDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @Valid 
  @Schema(name = "date", required = false)
  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public PricesDto finalPrice(Float finalPrice) {
    this.finalPrice = finalPrice;
    return this;
  }

  /**
   * Get finalPrice
   * @return finalPrice
  */
  
  @Schema(name = "finalPrice", required = false)
  public Float getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice(Float finalPrice) {
    this.finalPrice = finalPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricesDto prices = (PricesDto) o;
    return Objects.equals(this.idProduct, prices.idProduct) &&
        Objects.equals(this.idBrand, prices.idBrand) &&
        Objects.equals(this.fee, prices.fee) &&
        Objects.equals(this.date, prices.date) &&
        Objects.equals(this.finalPrice, prices.finalPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idProduct, idBrand, fee, date, finalPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricesDto {\n");
    sb.append("    idProduct: ").append(toIndentedString(idProduct)).append("\n");
    sb.append("    idBrand: ").append(toIndentedString(idBrand)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    finalPrice: ").append(toIndentedString(finalPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

