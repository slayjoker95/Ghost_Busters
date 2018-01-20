package com.ghost.busters.o_status.controller;

import com.ghost.busters.common.enums.ErrorCodeMap;
import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.o_status.model.OrderStatus;
import com.ghost.busters.o_status.service.OrderStatusService;
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
@RequestMapping("/api/o_status")
public class OrderStatusRestController {
    @Autowired
    private OrderStatusService orderStatusService;

    @ApiOperation(value = "Get all order statuses", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = GET)
    public ResponseEntity<List<OrderStatus>> getAllOrderStatus() {
        List<OrderStatus> orderStatusList = orderStatusService.findAll();
        return new ResponseEntity<List<OrderStatus>>(orderStatusList, HttpStatus.OK);
    }

    @ApiOperation(value = "Get order status by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderStatus> getOrderStatus(@ApiParam(value = "Order status id", required = true) @PathVariable String id) {
        OrderStatus orderStatus = orderStatusService.getByID(id);
        return new ResponseEntity<OrderStatus>(orderStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Create order status", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = POST)
    public ResponseEntity<? extends Object> createOrderStatus(@RequestBody OrderStatus orderStatus) {
        ErrorCodes code = orderStatusService.add(orderStatus);

        if (!code.equals(ErrorCodes.OK))
            return new ResponseEntity<String>(ErrorCodeMap.errors.get(code), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<OrderStatus>(orderStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Update order status", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<OrderStatus> updateOrderStatus(@RequestBody OrderStatus orderStatus) {
        orderStatusService.update(orderStatus);
        return new ResponseEntity<OrderStatus>(orderStatus, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete order status", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<OrderStatus> deleteOrderStatus(@ApiParam(value = "Order Status id", required = true) @PathVariable String id) {
        orderStatusService.delete(id);
        return new ResponseEntity<OrderStatus>(HttpStatus.OK);
    }

}
