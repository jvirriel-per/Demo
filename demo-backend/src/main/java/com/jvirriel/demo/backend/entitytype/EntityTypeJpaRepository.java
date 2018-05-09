package com.jvirriel.demo.backend.entitytype;

import com.jvirriel.demo.model.entitytype.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EntityTypeJpaRepository extends JpaRepository<EntityType, Integer>,
        JpaSpecificationExecutor<EntityType> {
}
