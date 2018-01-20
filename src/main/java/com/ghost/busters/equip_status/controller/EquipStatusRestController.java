package com.ghost.busters.equip_status.controller;

import com.ghost.busters.common.enums.ErrorCodeMap;
import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.equip_status.model.EquipStatus;
import com.ghost.busters.equip_status.service.EquipStatusService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/equip_status")
public class EquipStatusRestController {
    @Autowired
    private EquipStatusService equipStatusService;

    @ApiOperation(value = "Get all e statuses", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = GET)
    public ResponseEntity<List<EquipStatus>> getAllEquipStatus() {
        List<EquipStatus> equipStatusList = equipStatusService.findAll();
        return new ResponseEntity<List<EquipStatus>>(equipStatusList, HttpStatus.OK);
    }

    @ApiOperation(value = "Get equip status by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EquipStatus> getEquipStatus(@ApiParam(value = "Equip status id", required = true) @PathVariable String id) {
        EquipStatus equipStatus = equipStatusService.getByID(id);
        return new ResponseEntity<EquipStatus>(equipStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Create a equip status", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = POST)
    public ResponseEntity<? extends Object> createEquipStatus(@RequestBody EquipStatus equipStatus) {
        ErrorCodes code = equipStatusService.add(equipStatus);
        if (!code.equals(ErrorCodes.OK))
            return new ResponseEntity<String>(ErrorCodeMap.errors.get(code), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<EquipStatus>(equipStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Update equip status", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<EquipStatus> updateEquipStatus(@RequestBody EquipStatus equipStatus) {
        equipStatusService.update(equipStatus);
        return new ResponseEntity<EquipStatus>(equipStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a equip status", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<EquipStatus> deleteEquipStatus(@ApiParam(value = "Equip status id", required = true) @PathVariable String id) {
        equipStatusService.delete(id);
        return new ResponseEntity<EquipStatus>(HttpStatus.OK);
    }

}
