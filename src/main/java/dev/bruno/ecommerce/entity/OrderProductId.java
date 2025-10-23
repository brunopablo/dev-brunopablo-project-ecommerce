package dev.bruno.ecommerce.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderProductId {

    @ManyToOne()
    @JoinColumn(name="order_id")
    private OrderEntity order;

    @ManyToOne()
    @JoinColumn(name="product_id")
    private ProductEntity product;

    public OrderProductId() {
    }

    public OrderProductId(OrderEntity order, ProductEntity product) {
        this.order = order;
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    
}