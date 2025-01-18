package com.shopping.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String productName;
    private String description;
    private Double price;
    private int quantity;
    private String categoryId;
    private String sku;
    private String createdAt;
    private String updatedAt;
}
