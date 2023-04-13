package com.java.nisum.ps.api.repository;

import com.java.nisum.ps.api.entity.FundTransfer;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface FundTransferRepository extends MongoRepository <FundTransfer,String> {

    List<FundTransfer>  findByAccountFrom(String accountCode);

}
