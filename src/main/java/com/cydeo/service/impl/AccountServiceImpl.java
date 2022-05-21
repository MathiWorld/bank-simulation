package com.cydeo.service.impl;

import com.cydeo.enums.AccountStatus;
import com.cydeo.enums.AccountType;
import com.cydeo.model.Account;
import com.cydeo.repository.AccountRepository;
import com.cydeo.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountDTO> listAllAccount() {

        List<Account> accountList = accountRepository.findAll();

        return accountList.stream().map(accountMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void createNewAccount(AccountDTO accountDTO) {

        accountDTO.setCreationDate(new Date());
        accountDTO.setAccountStatus(AccountStatus.ACTIVE);
        accountRepository.save(accountMapper.convertToEntity(accountDTO));
    }


    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountRepository.getById(accountId);
        account.setAccountStatus(AccountStatus.DELETED);
        accountRepository.save(account);

    }

    @Override
    public AccountDTO retrieveById(Long account) {
        return accountMapper.convertToDto(accountRepository.getById(account));
    }

    @Override
    public List<AccountDTO> listAllActiveAccount() {

        List<Account> accountList = accountRepository.findAllByAccountStatus(AccountStatus.ACTIVE);

        return accountList.stream().map(accountMapper :: convertToDto).collect(Collectors.toList());

    }

}