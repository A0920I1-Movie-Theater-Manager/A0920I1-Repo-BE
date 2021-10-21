package com.service;

import com.model.dto.employeeAccount.CreateEmployeeAccount;
import com.model.dto.employeeAccount.UpdateEmployeeAccount;
import com.model.entity.Account;
import com.model.entity.Role;

import java.util.List;

public interface AccountService {

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
    boolean checkEmail(String email);
    boolean checkPhone(String phone);
    boolean checkUsername(String username);
    boolean checkAccountCode(String accountCode);

}
