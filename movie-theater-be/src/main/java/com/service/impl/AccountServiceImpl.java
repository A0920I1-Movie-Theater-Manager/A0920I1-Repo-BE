package com.service.impl;


import com.model.entity.Account;
import com.repository.AccountRepository;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    //HueHv
    @Override
    public List<Account> listAccountByCodeEmployee() {
        return accountRepository.listAccountByAccountCodeEmployee();
    }
}
