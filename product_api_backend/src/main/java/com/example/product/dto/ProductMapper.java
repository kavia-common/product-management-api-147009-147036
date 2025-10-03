package com.example.product.dto;

import com.example.product.model.Product;

/**
 * Utility class to map between Product entities and DTOs.
 */
public final class ProductMapper {

    private ProductMapper() {}

    public static ProductResponse toResponse(Product product) {
        if (product == null) return null;
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getQuantity()
        );
    }
}
