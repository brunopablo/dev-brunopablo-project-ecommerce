package dev.bruno.ecommerce.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    
    @Column(name="user_name")
    private String fullname;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="billing_address_fk")
    private BillingAddressEntity billingAddressEntity;

    public UserEntity() {
    }

    public UserEntity(Long id, String fullname, BillingAddressEntity billingAddress) {
        this.id = id;
        this.fullname = fullname;
        this.billingAddressEntity = billingAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public BillingAddressEntity getBillingAddress() {
        return billingAddressEntity;
    }

    public void setBillingAddress(BillingAddressEntity billingAddress) {
        this.billingAddressEntity = billingAddress;
    }
}
