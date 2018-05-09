package com.jvirriel.demo.backend.entitystatus;

import com.jvirriel.demo.model.entitystatus.EntityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface EntityStatusJpaRepository extends JpaRepository<EntityStatus, Integer>,
        JpaSpecificationExecutor<EntityStatus> {
}
