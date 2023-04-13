package com.java.nisum.ps.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account {


    private String accountCode;
    private String accountName;
    private String accountType;
    private String  address;

}

