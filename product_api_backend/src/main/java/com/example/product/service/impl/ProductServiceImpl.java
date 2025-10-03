package com.example.product.service.impl;

import com.example.product.dto.ProductMapper;
import com.example.product.dto.ProductRequest;
import com.example.product.dto.ProductResponse;
import com.example.product.exception.ResourceNotFoundException;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of ProductService using Spring Data JPA.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        Product entity = new Product(request.getName(), request.getPrice(), request.getQuantity());
        Product saved = repository.save(entity);
        return ProductMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getById(Long id) {
        Product p = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        return ProductMapper.toResponse(p);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAll() {
        return repository.findAll().stream()
            .map(ProductMapper::toResponse)
            .toList();
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        Product existing = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        existing.setName(request.getName());
        existing.setPrice(request.getPrice());
        existing.setQuantity(request.getQuantity());
        Product saved = repository.save(existing);
        return ProductMapper.toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }
        repository.deleteById(id);
    }
}
