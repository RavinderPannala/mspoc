package com.java.nisum.os.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.nisum.os.api.dto.Payment;
import com.java.nisum.os.api.request.TransactionRequest;
import com.java.nisum.os.api.response.TransactionResponse;
import com.java.nisum.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;
    
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest txnRequest) throws JsonProcessingException {
        return service.saveOrder(txnRequest);
    }

    @GetMapping("/getPaymentDetails/{orderId}")
    public Payment getPaymentDetails(@PathVariable  int orderId) throws JsonProcessingException {
        return service.getPaymentDetails(orderId);
    }
}
