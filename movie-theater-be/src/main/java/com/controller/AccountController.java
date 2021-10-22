package com.controller;

import com.model.dto.employeeAccount.CreateEmployeeAccount;
import com.model.dto.employeeAccount.UpdateEmployeeAccount;
import com.model.entity.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin("http://localhost:4200")
public class AccountController {
    @Autowired
    private AccountService accountService ;


    // danh sánh nhân viên (HoangLV)
    @GetMapping("employee-account-list")
    public ResponseEntity<List<Account>> getAllEmployee() {
        List<Account> listEmployeeDTOS = accountService.getAllEmployeeAccount();
        if (listEmployeeDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listEmployeeDTOS, HttpStatus.OK);
        }
    }

    // tìm kiếm nhân viên (HoangLV)
    @GetMapping("search-employee")
    public ResponseEntity<List<Account>> searchMeetingRoomByName(@RequestParam(required = false) String keyWord  ){
        List<Account> accounts = accountService.findEmployeeAccountByFullNameOrAccountCode(keyWord);
        return new ResponseEntity<>( accounts,HttpStatus.OK);
    }


    // get nhân viên theo id (HoangLV)
    @GetMapping("employee-account/{id}")
    public ResponseEntity<Account> getEmployeeById(@PathVariable("id") long id) {
        Account account = accountService.getAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    // sửa thông tin nhân viên (HoangLV)
    @PutMapping("employee-account-edit")
    public ResponseEntity<?> updateEmployee(@RequestBody UpdateEmployeeAccount updateEmployeeAccount) {
        accountService.updateEmployeeAccount(updateEmployeeAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // thêm mới nhân viên (HoangLV)
    @PostMapping(value="employee-account-create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeAccount createEmployeeAccount){
        if(createEmployeeAccount.getAccountCode() != null && createEmployeeAccount.getUsername() != null && createEmployeeAccount.getPassword() != null
                && createEmployeeAccount.getBirthday() != null && createEmployeeAccount.getGender() != null && createEmployeeAccount.getIdCard() != null
                && createEmployeeAccount.getEmail() != null && createEmployeeAccount.getAddress() != null && createEmployeeAccount.getFullname() != null
                && createEmployeeAccount.getIdCard() != null && createEmployeeAccount.getPhone() != null && createEmployeeAccount.getImageUrl() != null){
        createEmployeeAccount.setDeleted(true);
        createEmployeeAccount.setTotalPoint(0);
        accountService.createEmployeeAccount(createEmployeeAccount);
       Account account = accountService.findAccountByEmployeeName(createEmployeeAccount.getAccountCode());
        accountService.createAccountRole(account.getId(),2);
        return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Xóa nhân viên theo id  nhân viên (HoangLV)
    @DeleteMapping(value = "employee-account-delete/{id}")
    public ResponseEntity<?> deleteByEmployeeId(@PathVariable Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Không có tài khoản này !");
        }
        accountService.deleteEmployeeAccountById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // HoangLV
    @PostMapping("/check-email-employee")
    public boolean checkEmailEmployee(@RequestBody String email){
        return accountService.checkEmailEmployee(email);
    }
    @PostMapping("/check-phone-employee")
    public boolean checkPhoneEmployee(@RequestBody String phone){
        return accountService.checkPhoneEmployee(phone);
    }
    @PostMapping("/check-username-employee")
    public boolean checkUsernameEmployee(@RequestBody String username){
        return accountService.checkUsernameEmployee(username);
    }
    @PostMapping("/check-accountCode-employee")
    public boolean checkAccountCodeEmployee(@RequestBody String accountCode){
        System.out.println(accountCode);
        return accountService.checkAccountCodeEmployee(accountCode);
    }

}
