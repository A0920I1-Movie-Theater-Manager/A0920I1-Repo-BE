package com.service.impl;


import com.model.dto.AccountMemberDTO;
import com.model.dto.Viet.AccountUserDTO;
import com.model.dto.Viet.ManagerBooking;
import com.model.entity.Account;
import com.repository.AccountRepository;


import com.model.dto.employeeAccount.CreateEmployeeAccount;
import com.model.dto.employeeAccount.UpdateEmployeeAccount;


import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;


    //Viet hiển thị account theo id
    @Override
    public Account findAccountUpdateById(long id) {
        return accountRepository.findAccountUpdateById(id);

    }

    //  Viet lấy tất cả
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void updateAccount(AccountUserDTO accountUserDTO) {
        accountRepository.updateAccountUser(accountUserDTO.getAccountCode(), accountUserDTO.getAddress(), accountUserDTO.getBirthday(), accountUserDTO.getEmail(), accountUserDTO.getFullname(), accountUserDTO.getGender(), accountUserDTO.getIdCard(), accountUserDTO.getImageUrl(), accountUserDTO.getPassword(), accountUserDTO.getPhone(), accountUserDTO.getTotalPoint(), accountUserDTO.getUsername(), accountUserDTO.getId());
    }

    // Việt lấy danh sách vé
    @Override
    public List<ManagerBooking> ManagerTickets() {
        return accountRepository.ManagerTickets();
    }

    //Viet hiển thị vè theo id accout
    @Override
    public List<ManagerBooking> findAllBookByIdAccount(String idAccount) {
        return accountRepository.findAllFeedbackBookByIdAccount(idAccount);
    }

    //Viet Đổi mật khẩu
    @Override
    public void changePassword(AccountUserDTO accountUserDTO) {
        accountRepository.changePassword(accountUserDTO.getAccountCode(), accountUserDTO.getAddress(), accountUserDTO.getBirthday(), accountUserDTO.getEmail(), accountUserDTO.getFullname(), accountUserDTO.getGender(), accountUserDTO.getIdCard(), accountUserDTO.getImageUrl(), accountUserDTO.getPassword(), accountUserDTO.getPhone(), accountUserDTO.getTotalPoint(), accountUserDTO.getUsername(), accountUserDTO.getId());
    }

    //HueHv
    @Override
    public List<Account> listAccountByCodeEmployee() {
        return accountRepository.listAccountByAccountCodeEmployee();
    }

    @Override
    public List<Account> findAllMember() {
        return accountRepository.findAllMember();
    }


    @Override
    public void updateMember(AccountMemberDTO accountMemberDTO, long id) {
        accountRepository.updateMember(accountMemberDTO.getAccountCode(), accountMemberDTO.getAddress(), accountMemberDTO.getBirthday(),
                accountMemberDTO.getEmail(), accountMemberDTO.getFullname(), accountMemberDTO.getGender(), accountMemberDTO.getIdCard(),
                accountMemberDTO.getImageUrl(), accountMemberDTO.getPassword(), accountMemberDTO.getPhone(), accountMemberDTO.getUsername(),
                id);
    }

    @Override
    public void createMember(AccountMemberDTO accountMemberDTO) {
        accountRepository.createMember(accountMemberDTO.getAccountCode(), accountMemberDTO.getAddress(), accountMemberDTO.getBirthday(),
                accountMemberDTO.isDeleted(), accountMemberDTO.getEmail(), accountMemberDTO.getFullname(), accountMemberDTO.getGender(), accountMemberDTO.getIdCard(),
                accountMemberDTO.getImageUrl(), accountMemberDTO.getPassword(), accountMemberDTO.getPhone(), accountMemberDTO.getTotalPoint(), accountMemberDTO.getUsername());
    }

    @Override
    public void deleteMember(long id) {
        accountRepository.deleteMember(id);
    }

    @Override
    public Account findByIdMember(long id) {
        return accountRepository.findByIdMember(id);
    }

    @Override
    public List<Account> findByNameMember(String name) {
        return accountRepository.searchNameMember(name);
    }

    @Override
    public boolean checkEmailMember(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public boolean checkPhoneMember(String phone) {
        return accountRepository.existsByPhone(phone);
    }

    @Override
    public boolean checkUsernameMember(String username) {
        return accountRepository.existsByUsername(username);
    }

    // Danh sách nhân viên HoangLV
    @Override
    public List<Account> getAllEmployeeAccount() {
        return accountRepository.getAllAccountEmployee();
    }

    // Lấy nhân viên theo id HoangLV
    @Override
    public Account getAccountById(long id) {
        return accountRepository.getAccountById(id);
    }

    // Chỉnh sửa thông tin nhân viên HoangLV
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

    // Thêm mới nhân viên HoangLV
    @Override
    public void createEmployeeAccount(CreateEmployeeAccount createEmployeeAccount) {

        accountRepository.createEmployeeAccount(createEmployeeAccount.getAccountCode(),
                createEmployeeAccount.getAddress(),
                createEmployeeAccount.getBirthday(),
                createEmployeeAccount.getEmail(),
                createEmployeeAccount.getFullname(),
                createEmployeeAccount.getGender(),
                createEmployeeAccount.getIdCard(),
                createEmployeeAccount.getImageUrl(),
                createEmployeeAccount.getPassword(),
                createEmployeeAccount.getPhone(),
                createEmployeeAccount.getUsername(),
                createEmployeeAccount.isDeleted(),
                createEmployeeAccount.getTotalPoint()
        );

    }

    // phân quyền cho nhân viên HoangLV
    @Override
    public void createAccountRole(long accountId, long roleId) {
        accountRepository.createAccountRole(accountId, roleId);
    }

    // lấy nhân viên theo mã nhân viên HoangLV
    @Override
    public Account findAccountByEmployeeName(String accountCode) {
        return accountRepository.findAccountByEmployeeName(accountCode);
    }
    // HoangLV
    @Override
    public void deleteEmployeeAccountById(Long id) {
        accountRepository.deleteEmployeeAccountById(id);
    }
    // HoangLV
    @Override
    public List<Account> findEmployeeAccountByFullNameOrAccountCode(String keyWord) {
        return accountRepository.findEmployeeAccountByFullNameOrAccountCode(keyWord);
    }
    // HoangLV
    @Override
    public boolean checkEmailEmployee(String email) {
        return accountRepository.existsByEmail(email);
    }
    // HoangLV
    @Override
    public boolean checkPhoneEmployee(String phone) {
        return accountRepository.existsByPhone(phone);
    }
    // HoangLV
    @Override
    public boolean checkUsernameEmployee(String username) {
        return accountRepository.existsByUsername(username);
    }
    // HoangLV
    @Override
    public boolean checkAccountCodeEmployee(String accountCode) {
        return accountRepository.existsAccountsByAccountCode(accountCode);
    }

}




