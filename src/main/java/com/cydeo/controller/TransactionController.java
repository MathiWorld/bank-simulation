package com.cydeo.controller;

import com.cydeo.model.Account;
import com.cydeo.model.Transaction;
import com.cydeo.service.AccountService;
import com.cydeo.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

@Controller
public class TransactionController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public TransactionController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }


    @GetMapping("/make-transfer")
    public String retrieveTransactionForm(Model model){
        model.addAttribute("accounts", accountService.listAllAccount());
        model.addAttribute("transaction", Transaction.builder().build());
        model.addAttribute("lastTransactionList", transactionService.retrieveLastTransaction());

        return "transaction/make-transfer";

    }


    @PostMapping("/transfer")
    public String makeTransfer(@Valid @ModelAttribute("transaction")Transaction transaction, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("accounts", accountService.listAllAccount());
            return "transaction/make-transfer";
        }

        Account reciever = accountService.retriveById(transaction.getReceiver());
        Account sender = accountService.retriveById(transaction.getSender());
        transactionService.makeTransfer(transaction.getAmount(),new Date(),sender,reciever,transaction.getMessage());
        return "redirect:/make-transfer";

    }

    @GetMapping("/transaction/{id}")
    public String transactionDetailById(@PathVariable("id")UUID id, Model model) {

        model.addAttribute("transactionList", transactionService.findTransactionListById(id));

        return "transaction/transactions";
    }
}