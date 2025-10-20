package dev.bruno.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.bruno.ecommerce.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
