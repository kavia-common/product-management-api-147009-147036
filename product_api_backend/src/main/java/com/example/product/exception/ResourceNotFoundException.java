package com.example.product.exception;

/**
 * PUBLIC_INTERFACE
 * Exception thrown when a requested resource is not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) { super(message); }
}
