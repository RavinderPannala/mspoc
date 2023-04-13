package com.java.nisum.ps.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.nisum.ps.api.entity.Payment;
import com.java.nisum.ps.api.mapper.PaymentMapper;
import com.java.nisum.ps.api.model.PaymentDto;
import com.java.nisum.ps.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    PaymentMapper paymentMapper;

    @PostMapping("/doPayment")
    public PaymentDto doPayment(@RequestBody PaymentDto paymentDto) throws JsonProcessingException {
        Payment paymentEntity = paymentMapper.convertToEntity(paymentDto);
        Payment payment = paymentService.doPayment(paymentEntity);
        return paymentMapper.convertToDto(payment);
    }

    @GetMapping("/findPaymentHistoryByOrderId/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) throws JsonProcessingException {
              return paymentService.findPaymentHistoryByOrderId(orderId);
    }


}
