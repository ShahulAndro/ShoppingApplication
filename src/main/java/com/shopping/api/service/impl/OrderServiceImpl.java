package com.shopping.api.service.impl;

import com.shopping.api.exception.RecordNotFoundException;
import com.shopping.api.dto.CustomerOrderDTO;
import com.shopping.api.entity.CustomerOrder;
import com.shopping.api.mapper.OrderDataMapper;
import com.shopping.api.repository.OrderRepository;
import com.shopping.api.request.CustomerOrderRequest;
import com.shopping.api.service.OrderService;
import com.shopping.api.utility.AppUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<CustomerOrderDTO> getOrders() {
        return AppUtility.parseList(orderRepository.findAll(), OrderDataMapper::toDTO);
    }

    @Override
    public CustomerOrderDTO getOrder(Long orderId) {
        return OrderDataMapper.toDTO(findById(orderId));
    }

    @Override
    public CustomerOrderDTO saveOrder(CustomerOrderRequest orderRequest) {
        return OrderDataMapper.toDTO(orderRepository.save(OrderDataMapper.toEntity(orderRequest)));
    }

    @Override
    public CustomerOrderDTO updateOrder(Long id, CustomerOrderRequest orderRequest) {
        return OrderDataMapper.toDTO(orderRepository.save(OrderDataMapper.toEntity(orderRequest, findById(id))));
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.delete(findById(orderId));
    }

    private CustomerOrder findById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RecordNotFoundException("Order not found"));
    }
}
