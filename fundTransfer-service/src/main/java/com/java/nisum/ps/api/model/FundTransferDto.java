package com.java.nisum.ps.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundTransferDto {

    private String txnId;
    private String accountFrom;
    private String accountTo;
    private String benName;
    private double amount;
    private String ifsc;

}
