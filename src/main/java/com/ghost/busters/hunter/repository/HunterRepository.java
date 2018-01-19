package com.ghost.busters.hunter.repository;

import com.ghost.busters.hunter.model.Hunter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HunterRepository extends JpaRepository<Hunter, Long> {
    List<Hunter> findByName(String name);
}
