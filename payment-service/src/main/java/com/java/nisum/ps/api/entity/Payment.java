package com.java.nisum.ps.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "Payment")
public class Payment {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
}
