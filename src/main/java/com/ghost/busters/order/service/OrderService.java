package com.ghost.busters.order.service;

import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.order.model.Order;
import com.ghost.busters.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ghost.busters.common.enums.ErrorCodes.OK;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order getByID(String order_id)
    {
        return orderRepository.findOne(Long.valueOf(order_id));
    }

    public ErrorCodes add(Order order){
        orderRepository.save(order);
        return (OK);
    }
    public void delete(String order_id){
        orderRepository.delete(Long.valueOf(order_id));
    }

    public void update(Order newOrder)
    {
        Order order = orderRepository.findOne(newOrder.getOrder_id());
        order.setGhost_lvl(newOrder.getGhost_lvl());
        order.setStatus(newOrder.getStatus());
        order.setAdress(newOrder.getAdress());
        order.setEquip_st(newOrder.getEquip_st());
        order.setUser(newOrder.getUser());
        order.setHunter(newOrder.getHunter());
        orderRepository.flush();
    }

}
