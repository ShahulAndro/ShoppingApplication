package com.shopping.api.mapper;

import com.shopping.api.dto.CustomerOrderDTO;
import com.shopping.api.entity.CustomerOrder;
import com.shopping.api.request.CustomerOrderRequest;
import java.time.LocalDateTime;

public final class OrderDataMapper {

    public static CustomerOrderDTO toDTO(CustomerOrder order) {
        CustomerOrderDTO orderDTO = new CustomerOrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setCreatedAt(order.getCreatedAt());
        orderDTO.setUpdatedAt(order.getUpdatedAt());
        orderDTO.setPaymentMethod(order.getPaymentMethod());
        orderDTO.setShippingAddress(order.getShippingAddress());
        orderDTO.setShippingMethod(order.getShippingMethod());
        orderDTO.setPaymentStatus(order.getPaymentStatus());
        return orderDTO;
    }

    public static CustomerOrder toEntity(CustomerOrderRequest orderRequest) {
        return toEntity(orderRequest, new CustomerOrder());
    }

    public static CustomerOrder toEntity(CustomerOrderRequest orderRequest, CustomerOrder orderEntity) {
        orderEntity.setOrderDate(orderRequest.getOrderDate());
        orderEntity.setOrderStatus(orderRequest.getOrderStatus());
        orderEntity.setTotalAmount(orderRequest.getTotalAmount());
        orderEntity.setPaymentMethod(orderRequest.getPaymentMethod());
        orderEntity.setShippingAddress(orderRequest.getShippingAddress());
        orderEntity.setShippingMethod(orderRequest.getShippingMethod());
        orderEntity.setPaymentStatus(orderRequest.getPaymentStatus());
        if(orderEntity.getId() != null){
            orderEntity.setUpdatedAt(LocalDateTime.now().toString());
        }else{
            orderEntity.setCreatedAt(LocalDateTime.now().toString());
        }
        return orderEntity;
    }
}
