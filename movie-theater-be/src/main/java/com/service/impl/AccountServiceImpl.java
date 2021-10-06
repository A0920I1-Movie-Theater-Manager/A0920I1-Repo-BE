package com.service.impl;


import com.model.dto.employeeAccount.UpdateEmployeeAccount;
import com.model.entity.Account;
import com.repository.AccountRepository;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> getAllEmployeeAccount() {
        return accountRepository.getAllAccountEmployee();
    }

    @Override
    public Account getAccountById(long id) {
        return accountRepository.getAccountById(id);
    }

    @Override
    public void updateEmployeeAccount(UpdateEmployeeAccount updateEmployeeAccount) {
        accountRepository.updateEmployeeAccount(updateEmployeeAccount.getUsername(),
                updateEmployeeAccount.getPassword(),
                updateEmployeeAccount.getFullname(),
                updateEmployeeAccount.getBirthday(),
                updateEmployeeAccount.getGender(),
                updateEmployeeAccount.getEmail(),
                updateEmployeeAccount.getIdCard(),
                updateEmployeeAccount.getPhone(),
                updateEmployeeAccount.getAddress(),
                updateEmployeeAccount.getImageUrl(),
                updateEmployeeAccount.getAccountCode(),
                updateEmployeeAccount.getId());
    }
}
