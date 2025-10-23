package dev.bruno.ecommerce.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.bruno.ecommerce.controller.dto.CreateOrderRequest;
import dev.bruno.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        
        var orderCreated = orderService.createOrder(createOrderRequest);

        return ResponseEntity.created(URI.create("/orders/" + orderCreated.getId())).build();
    }
}
