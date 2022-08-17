package com.cydeo.banksimulation;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BankSimulationApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BankSimulationApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();


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
