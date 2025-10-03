package com.example.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Basic root endpoints for convenience and quick checks.
 */
@RestController
@Tag(name = "Root", description = "Utility endpoints for the Product API")
public class RootController {

    /**
     * PUBLIC_INTERFACE
     * Welcome endpoint.
     * @return welcome message
     */
    @GetMapping("/")
    @Operation(summary = "Welcome endpoint", description = "Returns a welcome message")
    public String hello() {
        return "Welcome to Product Management API";
    }

    /**
     * PUBLIC_INTERFACE
     * Redirect to Swagger UI.
     * @return redirect view to swagger-ui
     */
    @GetMapping("/docs")
    @Operation(summary = "API Documentation", description = "Redirects to Swagger UI")
    public RedirectView docs() {
        return new RedirectView("/swagger-ui.html");
    }

    /**
     * PUBLIC_INTERFACE
     * Health check endpoint.
     * @return health status
     */
    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Returns application health status")
    public String health() {
        return "OK";
    }

    /**
     * PUBLIC_INTERFACE
     * Application info.
     * @return application name
     */
    @GetMapping("/api/info")
    @Operation(summary = "Application info", description = "Returns application information")
    public String info() {
        return "Spring Boot Application: productapibackend";
    }
}
