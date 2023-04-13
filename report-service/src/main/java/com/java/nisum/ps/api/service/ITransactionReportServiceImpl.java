package com.java.nisum.ps.api.service;

import com.java.nisum.ps.api.model.Account;
import com.java.nisum.ps.api.model.FundTransfer;
import com.java.nisum.ps.api.model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ITransactionReportServiceImpl  implements ITransactionReportService{

   TransactionDetails txnDetails = new TransactionDetails();

    public  static final String ENDPOINT_URL_ACCOUNT = "http://ACCOUNT-SERVICE/banking/account/getAccountDetails/";

    public static final String ENDPOINT_URL_FUNDTRANSFER = "http://FUNDTRANSFER-SERVICE/banking/fundTransfer/getTxnsForAccount/";

    @Autowired
    RestTemplate restTemplate;
     @Override
    public TransactionDetails getTxnsDetails(String accountCode) {

       Account accout  =  restTemplate.getForObject(ENDPOINT_URL_ACCOUNT+accountCode,Account.class);
       List<FundTransfer> fundTransferList = restTemplate.getForObject(ENDPOINT_URL_FUNDTRANSFER+accountCode,List.class);
         txnDetails.setAccount(accout);
         txnDetails.setFundTransfer(fundTransferList);
         return txnDetails ;
    }
}
