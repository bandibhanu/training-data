package com.cg.app.Account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.Account.entity.Account;

@Repository

public interface AccountRepository extends MongoRepository<Account, Object>
{

}
