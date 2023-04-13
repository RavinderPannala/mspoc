package com.java.nisum.ps.api.mapper;

import com.java.nisum.ps.api.entity.FundTransfer;
import com.java.nisum.ps.api.model.FundTransferDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FundTransferMapper {

    @Autowired
    ModelMapper modelMapper;


    public FundTransferDto convertToDto(FundTransfer fundTransfer) {
        FundTransferDto fundTransferDto = modelMapper.map(fundTransfer, FundTransferDto.class);
        return fundTransferDto;
    }


    public FundTransfer convertToEntity(FundTransferDto fundTransferDto) {
        FundTransfer fundTransferEntity = modelMapper.map(fundTransferDto, FundTransfer.class);
        return fundTransferEntity;
    }


}
