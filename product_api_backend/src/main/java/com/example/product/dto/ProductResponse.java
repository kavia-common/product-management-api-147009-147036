package com.example.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

/**
 * PUBLIC_INTERFACE
 * Response payload for product data.
 */
@Schema(name = "ProductResponse", description = "Representational model of a product")
public class ProductResponse {

    @Schema(description = "Product identifier", example = "1")
    private Long id;

    @Schema(description = "Product name", example = "Wireless Mouse")
    private String name;

    @Schema(description = "Product price", example = "19.99")
    private BigDecimal price;

    @Schema(description = "Product quantity", example = "100")
    private Integer quantity;

    public ProductResponse() {}

    public ProductResponse(Long id, String name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
