package com.cydeo.service;

import com.cydeo.dto.AccountDTO;
import java.util.List;


public interface AccountService {
    void createNewAccount(AccountDTO accountDTO);

    List<AccountDTO> listAllAccount();

    List<AccountDTO> listAllActiveAccount();
    void deleteAccount(Long account);

    AccountDTO retrieveById(Long account);
}