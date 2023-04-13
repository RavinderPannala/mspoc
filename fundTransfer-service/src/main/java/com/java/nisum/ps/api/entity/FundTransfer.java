package com.java.nisum.ps.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection="Fund_Transfer")
public class FundTransfer {

    @Id
    private String txnId;
    private String accountFrom;
    private String accountTo;
    private String benName;
    private double amount;
    private String ifsc;


}

