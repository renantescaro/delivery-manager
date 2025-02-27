package com.codes_tech.delivery_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codes_tech.delivery_manager.model.DeliveryMan;


public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Long> {
    
}
