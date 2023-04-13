package com.java.nisum.ps.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.nisum.ps.api.entity.Payment;
import com.java.nisum.ps.api.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

import static com.java.nisum.ps.api.entity.Payment.SEQUENCE_NAME;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private SequenceGeneratorService service;
    
    Logger logger= LoggerFactory.getLogger(PaymentService.class);
    
    public Payment doPayment(Payment payment) throws JsonProcessingException {
        //generate sequence
        payment.setPaymentId(service.getSequenceNumber(SEQUENCE_NAME));
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        logger.info("Payment-Service Request : {}",new ObjectMapper().writeValueAsString(payment));

        return repository.save(payment);
    }


    public String paymentProcessing(){
        //api should be 3rd party payment gateway (paypal,paytm...)
     //   return new Random().nextBoolean()?"success":"false";
        return new Random().nextBoolean()?"success":"success";
    }


    public Payment findPaymentHistoryByOrderId(int orderId) throws JsonProcessingException {
        Payment payment=repository.findByOrderId(orderId);
        logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
        return payment ;
    }
}
