package com.example.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * PUBLIC_INTERFACE
 * The main entry point for the Product API Backend application.
 * Provides application bootstrap and OpenAPI metadata.
 */
@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Product Management API",
        version = "0.1.0",
        description = "A modern REST API for managing products with CRUD operations.",
        contact = @Contact(name = "Product API Team")
    )
)
public class ProductApiBackendApplication {

    /**
     * PUBLIC_INTERFACE
     * Bootstraps the Spring Boot application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductApiBackendApplication.class, args);
    }
}
