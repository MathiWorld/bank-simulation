package com.cydeo;

import com.cydeo.enums.AccountType;
import com.cydeo.model.Account;
import com.cydeo.service.AccountService;
import com.cydeo.service.TransactionService;
import com.cydeo.service.impl.AccountServiceImpl;
import com.cydeo.service.impl.TransactionServiceImpl;
import javafx.beans.binding.ListBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication //we dont need to create config class enable auto configuration
public class BankSimulationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankSimulationApplication.class, args);




          /*AccountService accountService = applicationContext.getBean(AccountServiceImpl.class);
          TransactionService transactionService = applicationContext.getBean(TransactionServiceImpl.class);

          Account receiver = accountService.createNewAccount( BigDecimal.TEN, new Date(), AccountType.CHECKINGS, 1L);
          Account sender =  accountService.createNewAccount(new BigDecimal(70), new Date(), AccountType.SAVINGS, 2L);

          accountService.listAllAccount().forEach(System.out::println);

          transactionService.makeTransfer(BigDecimal.TEN, new Date(), sender, receiver, "transfer no:1");

          System.out.println(transactionService.findAll().get(0));
          accountService.listAllAccount().forEach(System.out::println);

          transactionService.makeTransfer(new BigDecimal(25), new Date(), sender, receiver, "transfer no:2");

          System.out.println(transactionService.findAll().get(1));
          accountService.listAllAccount().forEach(System.out::println);*/
    }

}
