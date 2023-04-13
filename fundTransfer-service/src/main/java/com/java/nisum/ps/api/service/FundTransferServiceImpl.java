package com.java.nisum.ps.api.service;

import com.java.nisum.ps.api.entity.FundTransfer;
import com.java.nisum.ps.api.repository.FundTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundTransferServiceImpl  implements IFundTransferService{

    @Autowired
    FundTransferRepository fundTransferRepository ;

    @Override
    public FundTransfer processTxn(FundTransfer fundTransfer) {
        return fundTransferRepository.save(fundTransfer);
    }

    @Override
    public List<FundTransfer> getTxns() {
        return fundTransferRepository.findAll();
    }

    @Override
    public List<FundTransfer> getTxnsForAccount(String accountCode) {
        return fundTransferRepository.findByAccountFrom(accountCode);
    }
}
