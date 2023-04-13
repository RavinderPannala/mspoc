package com.java.nisum.ps.api.service;


import com.java.nisum.ps.api.model.TransactionDetails;



public interface ITransactionReportService {

    public TransactionDetails getTxnsDetails(String accountCode);


}
