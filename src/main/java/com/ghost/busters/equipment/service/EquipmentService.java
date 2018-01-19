package com.ghost.busters.equipment.service;

import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.equipment.model.Equipment;
import com.ghost.busters.equipment.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ghost.busters.common.enums.ErrorCodes.OK;


@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;


    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public Equipment getByID(String equipment_id)
    {
        return equipmentRepository.findOne(Long.valueOf(equipment_id));
    }

    public ErrorCodes add(Equipment equipment){
        equipmentRepository.save(equipment);
        return (OK);
    }
    public void delete(String equipment_id){
        equipmentRepository.delete(Long.valueOf(equipment_id));
    }

    public void update(Equipment newEquipment)
    {
        Equipment equipment = equipmentRepository.findOne(newEquipment.getEquipment_id());
        equipment.setLevel(newEquipment.getLevel());
        equipmentRepository.flush();
    }

}
