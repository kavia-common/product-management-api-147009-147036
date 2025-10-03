package com.example.product.controller;

import com.example.product.dto.ProductRequest;
import com.example.product.dto.ProductResponse;
import com.example.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * PUBLIC_INTERFACE
 * REST controller for product management endpoints.
 */
@RestController
@RequestMapping(path = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "CRUD operations for products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * PUBLIC_INTERFACE
     * Creates a new product.
     * @param request ProductRequest payload
     * @return 201 Created with ProductResponse body and Location header
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "Create product",
        description = "Create a new product with name, price, and quantity",
        responses = {
            @ApiResponse(responseCode = "201", description = "Product created",
                content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content)
        }
    )
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        ProductResponse created = service.create(request);
        return ResponseEntity
            .created(URI.create("/api/v1/products/" + created.getId()))
            .body(created);
    }

    /**
     * PUBLIC_INTERFACE
     * Retrieves a product by ID.
     * @param id product ID
     * @return 200 OK with ProductResponse
     */
    @GetMapping("/{id}")
    @Operation(
        summary = "Get product by ID",
        description = "Retrieve a single product by its ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK",
                content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
        }
    )
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    /**
     * PUBLIC_INTERFACE
     * Lists all products.
     * @return 200 OK with list of ProductResponse
     */
    @GetMapping
    @Operation(
        summary = "List products",
        description = "Retrieve all products",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK")
        }
    )
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    /**
     * PUBLIC_INTERFACE
     * Updates an existing product.
     * @param id product ID
     * @param request ProductRequest payload
     * @return 200 OK with updated ProductResponse
     */
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
        summary = "Update product",
        description = "Update a product by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK",
                content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Validation error", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
        }
    )
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        ProductResponse updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }

    /**
     * PUBLIC_INTERFACE
     * Deletes a product by ID.
     * @param id product ID
     * @return 204 No Content on success
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
        summary = "Delete product",
        description = "Delete a product by ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
        }
    )
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
