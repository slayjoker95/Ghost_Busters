package com.ghost.busters.hunter.service;

import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.hunter.model.Hunter;
import com.ghost.busters.hunter.repository.HunterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ghost.busters.common.enums.ErrorCodes.OK;

@Service
public class HunterService {
    @Autowired
    private HunterRepository hunterRepository;


    public List<Hunter> findAll() {
        return hunterRepository.findAll();
    }

    public Hunter getByID(String hunter_id)
    {
        return hunterRepository.findOne(Long.valueOf(hunter_id));
    }

    public ErrorCodes add(Hunter hunter){
        hunterRepository.save(hunter);
        return (OK);
    }
    public void delete(String hunter_id){
        hunterRepository.delete(Long.valueOf(hunter_id));
    }

    public void update(Hunter newHunter)
    {
        Hunter hunter = hunterRepository.findOne(newHunter.getHunter_id());
        hunter.setName(newHunter.getName());
        hunter.setLevel(newHunter.getLevel());
        hunter.setBusy(newHunter.getBusy());
        hunterRepository.flush();
    }

}
