package com.ghost.busters.o_status.repository;

import com.ghost.busters.o_status.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    List<OrderStatus> findByName(String name);
}
