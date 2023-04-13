package com.java.nisum.os.api.repository;

import com.java.nisum.os.api.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderRepository extends MongoRepository<Order,Integer> {


}
