package com.example.product.service;

import com.example.product.dto.ProductRequest;
import com.example.product.dto.ProductResponse;

import java.util.List;

/**
 * PUBLIC_INTERFACE
 * Service interface for managing products.
 */
public interface ProductService {

    /**
     * PUBLIC_INTERFACE
     * Creates a new product.
     * @param request product data
     * @return created product
     */
    ProductResponse create(ProductRequest request);

    /**
     * PUBLIC_INTERFACE
     * Retrieves a product by ID.
     * @param id product ID
     * @return product response
     */
    ProductResponse getById(Long id);

    /**
     * PUBLIC_INTERFACE
     * Lists all products.
     * @return list of products
     */
    List<ProductResponse> getAll();

    /**
     * PUBLIC_INTERFACE
     * Updates an existing product by ID.
     * @param id product ID
     * @param request updated data
     * @return updated product
     */
    ProductResponse update(Long id, ProductRequest request);

    /**
     * PUBLIC_INTERFACE
     * Deletes a product by ID.
     * @param id product ID
     */
    void delete(Long id);
}
