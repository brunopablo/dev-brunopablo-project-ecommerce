package dev.bruno.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.bruno.ecommerce.entity.OrderProductEntity;
import dev.bruno.ecommerce.entity.OrderItemId;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, OrderItemId>{

}
