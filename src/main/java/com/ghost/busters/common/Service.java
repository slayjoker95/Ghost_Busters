package com.ghost.busters.common;

import com.ghost.busters.equip_status.model.EquipStatus;
import com.ghost.busters.equip_status.repository.EquipStatusRepository;
import com.ghost.busters.hunter.model.Hunter;
import com.ghost.busters.hunter.repository.HunterRepository;
import com.ghost.busters.o_status.model.OrderStatus;
import com.ghost.busters.o_status.repository.OrderStatusRepository;
import com.ghost.busters.user.model.User;
import com.ghost.busters.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private HunterRepository hunterRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private EquipStatusRepository equipStatusRepository;
    @PostConstruct
    public void init() {
        hunterRepository.save(new Hunter("hunter", 1, false, "hunter"));
        userRepository.save(new User("user", "Пользователь", "user"));
        userRepository.save(new User("equip", "Поставщик", "equip"));
        userRepository.save(new User("disp", "Диспетчер", "disp"));
        equipStatusRepository.save(new EquipStatus("Подготавливается"));
        equipStatusRepository.save(new EquipStatus("Готова к выдаче"));
        equipStatusRepository.save(new EquipStatus("Выдана"));
        equipStatusRepository.save(new EquipStatus("Возвращена"));
        equipStatusRepository.save(new EquipStatus("Не возвращена"));
        orderStatusRepository.save(new OrderStatus("Не подтверждён"));
        orderStatusRepository.save(new OrderStatus("Подтверждён"));
        orderStatusRepository.save(new OrderStatus("Выполняется"));
        orderStatusRepository.save(new OrderStatus("Выполнен"));
        orderStatusRepository.save(new OrderStatus("Выполнен и подтверждён"));
    }
}
