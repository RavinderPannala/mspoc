package com.java.nisum.ps.api.model;

import com.java.nisum.ps.api.model.Account;
import com.java.nisum.ps.api.model.FundTransfer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetails {

    private Account account ;
    private List<FundTransfer> fundTransfer;



}

