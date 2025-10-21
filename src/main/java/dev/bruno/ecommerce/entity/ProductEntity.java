package dev.bruno.ecommerce.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_value")
    private BigDecimal value;

    @OneToMany(mappedBy = "id.product")
    private List<OrderProductEntity> order_itens;

    @JoinTable(name = "tb_products_tags", 
            joinColumns = @JoinColumn(name = "product_id"), 
            inverseJoinColumns = @JoinColumn(name = "tag_id"), 
            uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "tag_id"}
    ))

    @ManyToMany()
    private List<TagEntity> tags;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, BigDecimal value, List<OrderProductEntity> order_itens,
            List<TagEntity> tags) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.order_itens = order_itens;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public List<OrderProductEntity> getOrder_itens() {
        return order_itens;
    }

    public void setOrder_itens(List<OrderProductEntity> order_itens) {
        this.order_itens = order_itens;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }
}