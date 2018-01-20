package com.ghost.busters.o_status.service;

import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.o_status.model.OrderStatus;
import com.ghost.busters.o_status.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ghost.busters.common.enums.ErrorCodes.OK;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;


    public List<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }

    public OrderStatus getByID(String o_status_id)
    {
        return orderStatusRepository.findOne(Long.valueOf(o_status_id));
    }

    public ErrorCodes add(OrderStatus orderStatus){
        orderStatusRepository.save(orderStatus);
        return (OK);
    }
    public void delete(String o_status_id){
        orderStatusRepository.delete(Long.valueOf(o_status_id));
    }

    public void update(OrderStatus newOrderStatus)
    {
        OrderStatus orderStatus = orderStatusRepository.findOne(newOrderStatus.getId());
        orderStatus.setName(newOrderStatus.getName());
        orderStatusRepository.flush();
    }

}
