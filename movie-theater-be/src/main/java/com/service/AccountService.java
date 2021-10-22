package com.service;


import com.model.dto.AccountMemberDTO;
import com.model.dto.Viet.AccountUserDTO;
import com.model.dto.Viet.ManagerBooking;
import com.model.entity.Account;

import java.util.List;


public interface AccountService {

    //HueHV
    List<Account> listAccountByCodeEmployee();
    List<Account> findAllMember();
    void updateMember(AccountMemberDTO accountMemberDTO, long id);
    void createMember(AccountMemberDTO accountMemberDTO);
    void deleteMember(long id);
    Account findByIdMember(long id);
    List<Account> findByNameMember(String name);
    boolean checkEmailMember(String email);
    boolean checkPhoneMember(String phone);
    boolean checkUsernameMember(String username);

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
