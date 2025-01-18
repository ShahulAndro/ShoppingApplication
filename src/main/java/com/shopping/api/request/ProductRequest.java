package com.shopping.api.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    @NotNull
    private String productName;
    private String description;
    @NotNull
    private Double price;
    @NotEmpty
    private int quantity;
    private String categoryId;
    private String sku;
}
