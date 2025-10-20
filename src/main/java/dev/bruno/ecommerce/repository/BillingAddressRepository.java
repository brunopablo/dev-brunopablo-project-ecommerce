package dev.bruno.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.bruno.ecommerce.entity.BillingAddressEntity;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, Long>{

}
