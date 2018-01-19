package com.ghost.busters.prison.repository;

import com.ghost.busters.prison.model.Prison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrisonRepository extends JpaRepository<Prison, Long> {
    List<Prison> findById(Long id);

}
