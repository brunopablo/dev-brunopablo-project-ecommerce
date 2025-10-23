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
    private OrderProductId id;

    @Column(name="total_value")
    private BigDecimal priceValue;
    
    @Column(name="quantity")
    private Integer quantity;

    public OrderProductEntity() {
    }

    public OrderProductEntity(OrderProductId id, BigDecimal priceValue, Integer quantity) {
        this.id = id;
        this.priceValue = priceValue;
        this.quantity = quantity;
    }

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}