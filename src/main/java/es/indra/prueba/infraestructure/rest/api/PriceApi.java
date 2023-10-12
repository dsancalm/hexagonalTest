/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package es.indra.prueba.infraestructure.rest.api;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import es.indra.prueba.infraestructure.rest.model.PricesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull; 

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-12T10:37:29.962692900+02:00[Europe/Madrid]")
@Validated
@Tag(name = "price", description = "the price API")
public interface PriceApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /price : Recupera el precio
     * Recupera el precio del producto dada una fecha, un identificador de marca y un identificador de producto
     *
     * @param idBrand Id de la marca a buscar el precio (required)
     * @param idProduct Id del producto a buscar (required)
     * @param fecha Fecha (required)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     *         or Not found (status code 404)
     *         or Internal server error (status code 500)
     */
    @Operation(
        operationId = "findPriceByDateBrandProduct",
        summary = "Recupera el precio",
        tags = { "Prices" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PricesDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid status value"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/price",
        produces = { "application/json" }
    )
    default ResponseEntity<PricesDto> findPriceByDateBrandProduct(
        @NotNull @Parameter(name = "idBrand", description = "Id de la marca a buscar el precio", required = true) @Valid @RequestParam(value = "idBrand", required = true) Integer idBrand,
        @NotNull @Parameter(name = "idProduct", description = "Id del producto a buscar", required = true) @Valid @RequestParam(value = "idProduct", required = true) Integer idProduct,
        @NotNull @Parameter(name = "fecha", description = "Fecha", required = true) @Valid @RequestParam(value = "fecha", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"2000-01-23T04:56:07.000+00:00\", \"idBrand\" : 6, \"fee\" : 1, \"idProduct\" : 0, \"finalPrice\" : 5.962134 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
