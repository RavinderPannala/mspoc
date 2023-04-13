package com.java.nisum.ps.api.repository;

import com.java.nisum.ps.api.entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;



    public interface PaymentRepository extends MongoRepository<Payment,Integer>{
    Payment findByOrderId(int orderId);
}

