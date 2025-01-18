package com.shopping.api.controller;

import com.shopping.api.dto.CustomerOrderDTO;
import com.shopping.api.request.CustomerOrderRequest;
import com.shopping.api.service.OrderService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/list")
    @Hidden
    @Operation(summary = "Returns a list of Orders")
    public List<CustomerOrderDTO> listOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Returns a specific Order")
    public CustomerOrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping
    @Operation(summary = "Creates a new Order")
    public CustomerOrderDTO createOrder(@RequestBody @Validated CustomerOrderRequest orderRequest) {
        return orderService.saveOrder(orderRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updates an existing Order")
    public CustomerOrderDTO updateOrder(@PathVariable Long id, @RequestBody @Validated CustomerOrderRequest orderRequest) {
        return orderService.updateOrder(id, orderRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = " Deletes an Order")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
