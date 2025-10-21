package dev.bruno.ecommerce.service;

import org.springframework.stereotype.Service;

import dev.bruno.ecommerce.entity.OrderEntity;
import dev.bruno.ecommerce.repository.OrderProductRepository;
import dev.bruno.ecommerce.repository.OrderRepository;
import dev.bruno.ecommerce.repository.ProductRepository;
import dev.bruno.ecommerce.repository.UserRepository;

@Service
public class OrderService {

    private final UserRepository userRepository;

    private final OrderProductRepository orderProductRepository;

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    

    public OrderService(UserRepository userRepository,
            OrderProductRepository orderProductRepository,
            OrderRepository orderRepository,
            ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderProductRepository = orderProductRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }



    public OrderEntity createOrder() {
        

        return null;
    }
    

}
