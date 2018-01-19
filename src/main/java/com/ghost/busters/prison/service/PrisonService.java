package com.ghost.busters.prison.service;

import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.prison.model.Prison;
import com.ghost.busters.prison.repository.PrisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ghost.busters.common.enums.ErrorCodes.OK;

@Service
public class PrisonService {
    @Autowired
    private PrisonRepository prisonRepository;


    public List<Prison> findAll() {
        return prisonRepository.findAll();
    }

    public Prison getByID(String prison_id)
    {
        return prisonRepository.findOne(Long.valueOf(prison_id));
    }

    public ErrorCodes add(Prison prison){
        prisonRepository.save(prison);
        return (OK);
    }
    public void delete(String prison_id){
        prisonRepository.delete(Long.valueOf(prison_id));
    }

    public void update(Prison newPrison)
    {
        Prison prison = prisonRepository.findOne(newPrison.getPrison_id());
        prison.setOrder(newPrison.getOrder());
        prisonRepository.flush();
    }

}
