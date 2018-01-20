package com.ghost.busters.common;

import com.ghost.busters.hunter.model.Hunter;
import com.ghost.busters.hunter.repository.HunterRepository;
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
    @PostConstruct
    public void init() {
        hunterRepository.save(new Hunter("hunter", 1, false, "hunter"));
        userRepository.save(new User("user", "Пользователь", "user"));
        userRepository.save(new User("equip", "Поставщик", "equip"));
        userRepository.save(new User("disp", "Диспетчер", "disp"));
    }
}
