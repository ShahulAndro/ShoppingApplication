package com.shopping.api.controller;

import com.shopping.api.dto.ProductDTO;
import com.shopping.api.request.ProductRequest;
import com.shopping.api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    @Operation(summary = "List all products")
    public ResponseEntity<List<ProductDTO>> listProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Product")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    @Operation(summary = "Create Product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Validated ProductRequest productRequest) {
        ProductDTO createdDTO = productService.saveProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the Product")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody @Validated ProductRequest productRequest) {
        ProductDTO product = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete the Product")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
