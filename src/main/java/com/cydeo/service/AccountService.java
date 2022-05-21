package com.cydeo.service;

import com.cydeo.dto.AccountDTO;
import com.cydeo.enums.AccountType;
import com.cydeo.model.Account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AccountService {
    void createNewAccount(AccountDTO accountDTO);

    List<AccountDTO> listAllAccount();

    List<AccountDTO> listAllActiveAccount();
    void deleteAccount(Long account);

    AccountDTO retrieveById(Long account);
}