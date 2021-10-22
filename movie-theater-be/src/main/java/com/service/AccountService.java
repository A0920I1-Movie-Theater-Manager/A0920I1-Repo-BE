package com.service;

import com.dto.Viet.AccountUserDTO;
import com.dto.Viet.ManagerBooking;
import com.entity.Account;


import java.util.List;

public interface AccountService {
    //Hiển thị account theo id
    Account findAccountUpdateById(long id);

    //Viet hien thi tat ca account
    List<Account> findAll();

    //Viet cap nhat tai khoan nguoi dung
    void updateAccount(AccountUserDTO accountDTO);

    //Viet hien thi danh sach ve da đat
    List<ManagerBooking> ManagerTickets();

    //Viet hien thi danh sach ve theo id account
    List<ManagerBooking> findAllBookByIdAccount(String idAccount);

    //Viet Doi mat khau nguoi dung
    void changePassword(AccountUserDTO accountDTO);
}
