package com.ghost.busters.user.repository;

import com.ghost.busters.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

}
