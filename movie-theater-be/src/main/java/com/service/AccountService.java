package com.service;

import com.dto.Viet.AccountUserDTO;
import com.dto.Viet.ManagerBooking;
import com.entity.Account;


import java.util.List;

public interface AccountService {
    Account findAccountUpdateById(long id);
    List<Account> findAll();
    void updateAccount(AccountUserDTO accountDTO);
    List<ManagerBooking> ManagerTickets();
    List<ManagerBooking> findAllBookByIdAccount(String idAccount);
    void changePassword(AccountUserDTO accountDTO);
}
