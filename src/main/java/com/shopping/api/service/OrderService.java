package com.shopping.api.service;

import com.shopping.api.dto.CustomerOrderDTO;
import com.shopping.api.request.CustomerOrderRequest;

import java.util.List;

public interface OrderService {
    List<CustomerOrderDTO> getOrders();
    CustomerOrderDTO getOrder(Long orderId);
    CustomerOrderDTO saveOrder(CustomerOrderRequest orderRequest);
    CustomerOrderDTO updateOrder(Long id, CustomerOrderRequest orderRequest);
    void deleteOrder(Long orderId);
}
