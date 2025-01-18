package com.shopping.api.mapper;


import com.shopping.api.dto.ProductDTO;
import com.shopping.api.entity.Product;
import com.shopping.api.request.ProductRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDataMapper {

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setCategoryId(product.getCategoryId());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setSku(product.getSku());
        productDTO.setCreatedAt(product.getCreatedAt());
        productDTO.setUpdatedAt(product.getUpdatedAt());
        return productDTO;
    }

    public static Product toEntity(ProductRequest productRequest) {
        return toEntity(productRequest, new Product());
    }

    public static Product toEntity(ProductRequest productRequest, Product product) {
        product.setProductName(productRequest.getProductName());
        product.setCategoryId(productRequest.getCategoryId());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setSku(productRequest.getSku());
        if (product.getId() == null) {
            product.setCreatedAt(LocalDateTime.now().toString());
        } else {
            product.setUpdatedAt(LocalDateTime.now().toString());
        }

        return product;
    }
}
