package com.ghost.busters.equipment.controller;

import com.ghost.busters.common.enums.ErrorCodeMap;
import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.equipment.model.Equipment;
import com.ghost.busters.equipment.service.EquipmentService;
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
@RequestMapping("/api/equipment")
public class EquipmentRestController {
    @Autowired
    private EquipmentService equipmentService;

    @ApiOperation(value = "Get all equipment", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = GET)
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipment = equipmentService.findAll();
        return new ResponseEntity<List<Equipment>>(equipment, HttpStatus.OK);
    }

    @ApiOperation(value = "Get equipment by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Equipment> getEquipment(@ApiParam(value = "Equipment id", required = true) @PathVariable String id) {
        Equipment equipment = equipmentService.getByID(id);
        return new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
    }

    @ApiOperation(value = "Create a equipment", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = POST)
    public ResponseEntity<? extends Object> createEquipment(@RequestBody Equipment equipment) {
        ErrorCodes code = equipmentService.add(equipment);

        if (!code.equals(ErrorCodes.OK))
            return new ResponseEntity<String>(ErrorCodeMap.errors.get(code), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a equipment", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Equipment> updateEquipment(@RequestBody Equipment equipment) {
        equipmentService.update(equipment);
        return new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a equipment", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Equipment> deleteEquipment(@ApiParam(value = "Equipment id", required = true) @PathVariable String id) {
        equipmentService.delete(id);
        return new ResponseEntity<Equipment>(HttpStatus.OK);
    }

}
