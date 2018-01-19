package com.ghost.busters.order.repository;

import com.ghost.busters.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findById(Long id);

}
