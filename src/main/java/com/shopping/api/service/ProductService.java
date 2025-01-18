package com.shopping.api.service;

import com.shopping.api.dto.ProductDTO;
import com.shopping.api.request.ProductRequest;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts();
    ProductDTO saveProduct(ProductRequest productRequest);
    ProductDTO getProduct(Long id);
    ProductDTO updateProduct(Long id, ProductRequest productRequest);
    void deleteProduct(Long id);

}
