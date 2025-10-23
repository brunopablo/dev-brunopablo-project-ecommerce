package dev.bruno.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.bruno.ecommerce.entity.TagEntity;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long>{

}
