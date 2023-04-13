package com.java.nisum.os.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.nisum.os.api.repository.OrderRepository;
import com.java.nisum.os.api.dto.Payment;
import com.java.nisum.os.api.entity.Order;
import com.java.nisum.os.api.request.TransactionRequest;
import com.java.nisum.os.api.response.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    Logger logger= LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderRepository repository;
    @Autowired
    @Lazy
    private RestTemplate template;

 // @Value("${microservice.payment-service.endpoints.endpoint.uri}")
   //private String ENDPOINT_URL ;
   private String ENDPOINT_URL = "http://PAYMENT-SERVICE/payment/doPayment";

    private String ENDPOINT_URL_PAYMENT_HISTORY = "http://PAYMENT-SERVICE/payment/findPaymentHistoryByOrderId/";

    public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        logger.info("Order-Service Request : "+new ObjectMapper().writeValueAsString(request));
        Payment paymentResponse = template.postForObject(ENDPOINT_URL, payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";
        logger.info("Order Service getting Response from Payment-Service : "+new ObjectMapper().writeValueAsString(response));
        repository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }

    public Payment getPaymentDetails( int orderId) throws JsonProcessingException {

        Payment paymentResponse = template.getForObject(ENDPOINT_URL_PAYMENT_HISTORY+orderId,Payment.class);
        return paymentResponse ;
    }


}
