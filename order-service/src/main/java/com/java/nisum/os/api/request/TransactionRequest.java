package com.java.nisum.os.api.request;

import com.java.nisum.os.api.dto.Payment;
import com.java.nisum.os.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;
    private Payment payment;
}
