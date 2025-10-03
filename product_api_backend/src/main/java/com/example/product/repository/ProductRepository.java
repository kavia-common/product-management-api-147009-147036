package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PUBLIC_INTERFACE
 * Repository for Product entities providing CRUD operations.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
