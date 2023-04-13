package com.java.nisum.ps.api.controller;

import com.java.nisum.ps.api.mapper.FundTransferMapper;
import com.java.nisum.ps.api.model.FundTransferDto;
import com.java.nisum.ps.api.service.IFundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.java.nisum.ps.api.entity.FundTransfer;

import java.util.List;

@RestController
@RequestMapping("/banking/fundTransfer")
public class FundTransferController {

    @Autowired
    IFundTransferService fundTransferService ;

    @Autowired
    FundTransferMapper fundTransferMapper;

    @PostMapping ("/processFundTransfer")
    public FundTransferDto processTxn(@RequestBody FundTransferDto fundTransferDto)
    {   FundTransfer fundTransferEntity = fundTransferMapper.convertToEntity(fundTransferDto);
        FundTransfer fundTransfer = fundTransferService.processTxn(fundTransferEntity);
        return fundTransferMapper.convertToDto(fundTransfer);

    }

    @GetMapping ("/getAllTxns")
    public List<FundTransfer> getAllTxns()
    {
        return fundTransferService.getTxns()  ;
    }


    @GetMapping ("/getTxnsForAccount/{accountCode}")
    public List<FundTransfer> getTxnsForAccount(@PathVariable String accountCode)
    {
        return fundTransferService.getTxnsForAccount(accountCode);
    }

}
