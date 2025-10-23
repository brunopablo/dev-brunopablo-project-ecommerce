package dev.bruno.ecommerce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.bruno.ecommerce.controller.dto.CreateOrderRequest;
import dev.bruno.ecommerce.controller.dto.OrderProductDto;
import dev.bruno.ecommerce.entity.OrderEntity;
import dev.bruno.ecommerce.entity.OrderProductEntity;
import dev.bruno.ecommerce.entity.OrderProductId;
import dev.bruno.ecommerce.entity.ProductEntity;
import dev.bruno.ecommerce.entity.UserEntity;
import dev.bruno.ecommerce.repository.OrderProductRepository;
import dev.bruno.ecommerce.repository.OrderRepository;
import dev.bruno.ecommerce.repository.ProductRepository;
import dev.bruno.ecommerce.repository.UserRepository;

@Service
public class OrderService {

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    public OrderService(
            UserRepository userRepository,
            OrderProductRepository orderProductRepository,
            OrderRepository orderRepository,
            ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderEntity createOrder(CreateOrderRequest orderData) {
    
        var orderEntity = new OrderEntity();

        var userEntity = getUserEntity(orderData.userId());

        var listOrderProductsEntity = getOrderProductsEntity(orderEntity, orderData.products());

        var total = calculateOrderTotalValue(listOrderProductsEntity);

        orderEntity.setOrdersProducts(listOrderProductsEntity);

        orderEntity.setTotalValue(total);

        orderEntity.setUser(userEntity);

        orderEntity.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(orderEntity);
    }

    private BigDecimal calculateOrderTotalValue(List<OrderProductEntity> listOrderProductsEntity) {
        
        return listOrderProductsEntity.stream().
                map(orderProduct -> orderProduct.getPriceValue().multiply(BigDecimal.valueOf(orderProduct.getQuantity()))).
                reduce(BigDecimal::add).
                orElse(BigDecimal.ZERO);
    }

    private List<OrderProductEntity> getOrderProductsEntity(OrderEntity orderEntity, List<OrderProductDto> products) {

        if (products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Products not be empty");
        }

        return products.stream().map(
                product -> getOrderProduct(orderEntity, product)).toList();
    }

    private OrderProductEntity getOrderProduct(OrderEntity orderEntity, OrderProductDto product) {

        var productEntity = getProductEntity(product);

        var orderProductId = new OrderProductId(
            orderEntity,
            productEntity
        );

        var orderProductEntity = new OrderProductEntity();

        orderProductEntity.setId(orderProductId);

        orderProductEntity.setQuantity(product.quantity());

        orderProductEntity.setPriceValue(productEntity.getValue());

        return orderProductEntity;
    }

    private ProductEntity getProductEntity(OrderProductDto product) {
        return productRepository.findById(product.id()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found"));
    }

    private UserEntity getUserEntity(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}