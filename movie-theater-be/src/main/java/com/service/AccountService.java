package com.service;



import com.model.dto.AccountMemberDTO;
import com.model.dto.Viet.AccountUserDTO;
import com.model.dto.Viet.ManagerBooking;
import com.model.entity.Account;

import com.model.dto.employeeAccount.CreateEmployeeAccount;
import com.model.dto.employeeAccount.UpdateEmployeeAccount;


import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
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
        //Viet tim tai khoan
    Boolean findAccountByVerificationCode(String code);
    String existsByUserName(String username);
    Boolean findAccountByVerificationCodeToResetPassword(String code);
    void saveNewPassword(String password,String code);
    void addVerificationCode(String username) throws MessagingException, UnsupportedEncodingException;


    // Danh sách nhân viên HoangLV
    List<Account> getAllEmployeeAccount();

    // lấy nhân viên theo id HoangLV
    Account getAccountById(long id);

    // chỉnh sửa thông tin nhân viên HoangLV
    void updateEmployeeAccount(UpdateEmployeeAccount updateEmployeeAccount);

    // thêm mới thông tin nhân viên HoangLV
    void createEmployeeAccount(CreateEmployeeAccount createEmployeeAccount);

    // phân quyền cho nhân viên HoangLV
    void createAccountRole(long accountId, long roleId);

    // lấy thông tin nhân viên theo mã nhân viên HoangLV
    Account findAccountByEmployeeName(String accountCode);

    void deleteEmployeeAccountById(Long id);

    //search nhan vien HoangLV
    List<Account> findEmployeeAccountByFullNameOrAccountCode(String keyWord);

    //HoangLV
    boolean checkEmailEmployee(String email);
    boolean checkPhoneEmployee(String phone);
    boolean checkUsernameEmployee(String username);
    boolean checkAccountCodeEmployee(String accountCode);



}
