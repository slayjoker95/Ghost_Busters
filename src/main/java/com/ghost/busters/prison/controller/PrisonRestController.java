package com.ghost.busters.prison.controller;

import com.ghost.busters.common.enums.ErrorCodeMap;
import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.prison.model.Prison;
import com.ghost.busters.prison.service.PrisonService;
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
@RequestMapping("/api/prison")
public class PrisonRestController {
    @Autowired
    private PrisonService prisonService;

    @ApiOperation(value = "Get all prisoners", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = GET)
    public ResponseEntity<List<Prison>> getAllPrisoners() {
        List<Prison> prisoners = prisonService.findAll();
        return new ResponseEntity<List<Prison>>(prisoners, HttpStatus.OK);
    }

    @ApiOperation(value = "Get prisoner by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Prison> getPrison(@ApiParam(value = "Prison id", required = true) @PathVariable String id) {
        Prison prisoner = prisonService.getByID(id);
        return new ResponseEntity<Prison>(prisoner, HttpStatus.OK);
    }

    @ApiOperation(value = "Create a prisoner", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = POST)
    public ResponseEntity<? extends Object> createPrisoner(@RequestBody Prison prisoner) {
        ErrorCodes code = prisonService.add(prisoner);

        if (!code.equals(ErrorCodes.OK))
            return new ResponseEntity<String>(ErrorCodeMap.errors.get(code), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<Prison>(prisoner, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a prisoner", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Prison> updatePrisoner(@RequestBody Prison prisoner) {
        prisonService.update(prisoner);
        return new ResponseEntity<Prison>(prisoner, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a prisoner", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Prison> deletePrisoner(@ApiParam(value = "Prisoner id", required = true) @PathVariable String id) {
        prisonService.delete(id);
        return new ResponseEntity<Prison>(HttpStatus.OK);
    }

}
