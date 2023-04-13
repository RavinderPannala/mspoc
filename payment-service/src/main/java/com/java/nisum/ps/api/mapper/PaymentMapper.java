package com.java.nisum.ps.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.java.nisum.ps.api.entity.Payment;
import com.java.nisum.ps.api.model.PaymentDto;
import org.modelmapper.ModelMapper;


@Component
public class PaymentMapper {


    @Autowired
    ModelMapper modelMapper;


    public PaymentDto convertToDto(Payment payment) {
        PaymentDto paymentDto = modelMapper.map(payment, PaymentDto.class);
        return paymentDto;
    }


    public Payment convertToEntity(PaymentDto paymentDto) {
        Payment paymentEntity = modelMapper.map(paymentDto, Payment.class);
        return paymentEntity;
    }


}


