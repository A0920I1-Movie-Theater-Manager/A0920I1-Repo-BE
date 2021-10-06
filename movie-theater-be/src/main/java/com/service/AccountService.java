package com.service;

import com.model.dto.employeeAccount.UpdateEmployeeAccount;
import com.model.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllEmployeeAccount();

    Account getAccountById(long id);

    void updateEmployeeAccount(UpdateEmployeeAccount updateEmployeeAccount);
}
