package com.ghost.busters.equip_status.service;

import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.equip_status.model.EquipStatus;
import com.ghost.busters.equip_status.repository.EquipStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ghost.busters.common.enums.ErrorCodes.OK;

@Service
public class EquipStatusService {
    @Autowired
    private EquipStatusRepository equipStatusRepository;


    public List<EquipStatus> findAll() {
        return equipStatusRepository.findAll();
    }

    public EquipStatus getByID(String e_status_id)
    {
        return equipStatusRepository.findOne(Long.valueOf(e_status_id));
    }

    public ErrorCodes add(EquipStatus equipStatus){
        equipStatusRepository.save(equipStatus);
        return (OK);
    }
    public void delete(String e_status_id){
        equipStatusRepository.delete(Long.valueOf(e_status_id));
    }

    public void update(EquipStatus newEquipStatus)
    {
        EquipStatus equipStatus= equipStatusRepository.findOne(newEquipStatus.getId());
        equipStatus.setName(newEquipStatus.getName());
        equipStatusRepository.flush();
    }

}
