package com.shopping.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerOrderDTO {
    private Long id;
    private String orderDate;
    private String orderStatus;
    private String totalAmount;
    private String paymentStatus;
    private String shippingMethod;
    private String shippingAddress;
    private String paymentMethod;
    private String createdAt;
    private String updatedAt;
}
