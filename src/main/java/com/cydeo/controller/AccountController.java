package com.cydeo.controller;


import com.cydeo.enums.AccountType;
import com.cydeo.model.Account;
import com.cydeo.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/index")
    public String accountList(Model model) {
        model.addAttribute("accountList", accountService.listAllAccount());
        return "account/index";
    }

    @GetMapping("/create-form")
    public String getCreateForm(Model model){
        model.addAttribute("account", Account.builder().build());
        model.addAttribute("accountTypes", AccountType.values());
        return "account/create-account";

    }
    @PostMapping("/create")
    public String createAccount(@ModelAttribute("account") Account account, Model model){
        accountService.createNewAccount(account.getBalance(),
                new Date(),
                account.getAccountType(),
                account.getUserId());
        model.addAttribute("accountList",accountService.listAllAccount());

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")UUID id){
        accountService.deleteAccount(id);
        return "redirect:/index";

    }





}