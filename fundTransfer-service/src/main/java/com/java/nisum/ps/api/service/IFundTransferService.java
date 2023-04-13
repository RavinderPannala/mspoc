package com.java.nisum.ps.api.service;

import com.java.nisum.ps.api.entity.FundTransfer;
import java.util.List;

public interface IFundTransferService {

    public FundTransfer processTxn(FundTransfer fundTransfer);
    public List<FundTransfer> getTxns();
    public List<FundTransfer> getTxnsForAccount(String accountCode);


}
