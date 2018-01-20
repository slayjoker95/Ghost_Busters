package com.ghost.busters.equip_status.repository;

import com.ghost.busters.equip_status.model.EquipStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipStatusRepository extends JpaRepository<EquipStatus, Long> {
    List<EquipStatus> findByName(String name);
}
