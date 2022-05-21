package com.cydeo.repository;

import com.cydeo.enums.AccountStatus;
import com.cydeo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {



    List<Account> findAllByAccountStatus(AccountStatus active);
}