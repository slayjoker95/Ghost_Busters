package com.ghost.busters.hunter.controller;

import com.ghost.busters.common.enums.ErrorCodeMap;
import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.hunter.model.Hunter;
import com.ghost.busters.hunter.service.HunterService;
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
@RequestMapping("/api/hunter")
public class HunterRestController {
    @Autowired
    private HunterService hunterService;

    @ApiOperation(value = "Get all hunters", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = GET)
    public ResponseEntity<List<Hunter>> getAllHunters() {
        List<Hunter> hunters = hunterService.findAll();
        return new ResponseEntity<List<Hunter>>(hunters, HttpStatus.OK);
    }

    @ApiOperation(value = "Get hunter by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Hunter> getHunter(@ApiParam(value = "Hunter id", required = true) @PathVariable String id) {
        Hunter hunter = hunterService.getByID(id);
        return new ResponseEntity<Hunter>(hunter, HttpStatus.OK);
    }

    @ApiOperation(value = "Create a hunter", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = POST)
    public ResponseEntity<? extends Object> createHunter(@RequestBody Hunter hunter) {
        ErrorCodes code = hunterService.add(hunter);

        if (!code.equals(ErrorCodes.OK))
            return new ResponseEntity<String>(ErrorCodeMap.errors.get(code), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<Hunter>(hunter, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a hunter", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Hunter> updateHunter(@RequestBody Hunter hunter) {
        hunterService.update(hunter);
        return new ResponseEntity<Hunter>(hunter, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a hunter", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Hunter> deleteHunter(@ApiParam(value = "Hunter id", required = true) @PathVariable String id) {
        hunterService.delete(id);
        return new ResponseEntity<Hunter>(HttpStatus.OK);
    }

}
