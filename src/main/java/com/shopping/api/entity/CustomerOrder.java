package com.shopping.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
