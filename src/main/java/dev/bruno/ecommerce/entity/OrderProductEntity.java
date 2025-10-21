package dev.bruno.ecommerce.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order_item")
public class OrderProductEntity {

    @EmbeddedId
    @Column(name="order_item_id")
    private OrderItemId id;

    @Column(name="total_value")
    private BigDecimal totalValue;
    
    @Column(name="quantity")
    private Integer quantity;

    public OrderProductEntity() {
    }

    public OrderProductEntity(OrderItemId id, BigDecimal totalValue, Integer quantity) {
        this.id = id;
        this.totalValue = totalValue;
        this.quantity = quantity;
    }

    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId id) {
        this.id = id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}