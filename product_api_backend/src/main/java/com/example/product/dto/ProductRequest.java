package com.example.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * PUBLIC_INTERFACE
 * Request payload for creating or updating a product.
 */
@Schema(name = "ProductRequest", description = "Payload for creating or updating a product")
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(max = 200, message = "Product name must be at most 200 characters")
    @Schema(description = "Product name", example = "Wireless Mouse", maxLength = 200)
    private String name;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be non-negative")
    @Digits(integer = 12, fraction = 2, message = "Price must be a valid monetary amount")
    @Schema(description = "Product price", example = "19.99", minimum = "0.0")
    private BigDecimal price;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity must be non-negative")
    @Schema(description = "Product quantity", example = "100", minimum = "0")
    private Integer quantity;

    public ProductRequest() {}

    public ProductRequest(String name, BigDecimal price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
