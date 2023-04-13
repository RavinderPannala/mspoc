package com.java.nisum.ps.api.controller;


import com.java.nisum.ps.api.model.TransactionDetails;
import com.java.nisum.ps.api.service.ITransactionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/banking/reports")
public class ReportController {

    @Autowired
    ITransactionReportService iTransactionReportService ;

    @GetMapping ("/getAllTxnsDetailsByAccountNo/{accountCode}")
    public TransactionDetails getAllTxnsDetailsByAccountNo(@PathVariable String accountCode)

    {  return iTransactionReportService.getTxnsDetails(accountCode)  ;
    }




}
