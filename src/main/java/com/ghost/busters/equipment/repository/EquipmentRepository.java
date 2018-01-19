package com.ghost.busters.equipment.repository;

import com.ghost.busters.equipment.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findById(Long id);

}
