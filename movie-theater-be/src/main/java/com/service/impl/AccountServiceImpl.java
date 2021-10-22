package com.service.impl;


import com.model.dto.employeeAccount.CreateEmployeeAccount;
import com.model.dto.employeeAccount.UpdateEmployeeAccount;
import com.model.entity.Account;
import com.model.entity.Role;
import com.repository.AccountRepository;
import com.repository.RoleRepository;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


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

    @Override
    public void deleteEmployeeAccountById(Long id) {
        accountRepository.deleteEmployeeAccountById(id);
    }

    @Override
    public List<Account> findEmployeeAccountByFullNameOrAccountCode(String keyWord) {
        return accountRepository.findEmployeeAccountByFullNameOrAccountCode(keyWord);
    }

    @Override
    public boolean checkEmailEmployee(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public boolean checkPhoneEmployee(String phone) {
        return accountRepository.existsByPhone(phone);
    }

    @Override
    public boolean checkUsernameEmployee(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public boolean checkAccountCodeEmployee(String accountCode) {
        return accountRepository.existsAccountsByAccountCode(accountCode);
    }
}
