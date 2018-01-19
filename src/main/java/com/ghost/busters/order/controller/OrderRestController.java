package com.ghost.busters.order.controller;

import com.ghost.busters.common.enums.ErrorCodeMap;
import com.ghost.busters.common.enums.ErrorCodes;
import com.ghost.busters.order.model.Order;
import com.ghost.busters.order.service.OrderService;
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
@RequestMapping("/api/order")
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "Get all orders", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = GET)
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @ApiOperation(value = "Get order by id", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Order> getOrder(@ApiParam(value = "Order id", required = true) @PathVariable String id) {
        Order order = orderService.getByID(id);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @ApiOperation(value = "Create a order", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = POST)
    public ResponseEntity<? extends Object> createOrder(@RequestBody Order order) {
        ErrorCodes code = orderService.add(order);

        if (!code.equals(ErrorCodes.OK))
            return new ResponseEntity<String>(ErrorCodeMap.errors.get(code), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a order", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        orderService.update(order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a order", produces = APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Order> deleteOrder(@ApiParam(value = "Order id", required = true) @PathVariable String id) {
        orderService.delete(id);
        return new ResponseEntity<Order>(HttpStatus.OK);
    }

}
