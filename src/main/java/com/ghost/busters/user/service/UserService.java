package com.ghost.busters.user.service;

import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.user.model.User;
import com.ghost.busters.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ghost.busters.common.enums.ErrorCodes.OK;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getByID(String user_id)
    {
        return userRepository.findOne(Long.valueOf(user_id));
    }

    public ErrorCodes add(User user){
        userRepository.save(user);
        return (OK);
    }
    public void delete(String user_id){
        userRepository.delete(Long.valueOf(user_id));
    }

    public void update(User newUser)
    {
        User user = userRepository.findOne(newUser.getUser_id());
        user.setName(newUser.getName());
        user.setRole(newUser.getRole());
        user.setPassword(newUser.getPassword());
        userRepository.flush();
    }

}
