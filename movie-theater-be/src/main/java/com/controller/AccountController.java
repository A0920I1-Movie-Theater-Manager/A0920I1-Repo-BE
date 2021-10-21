package com.controller;

import com.model.dto.employeeAccount.CreateEmployeeAccount;
import com.model.dto.employeeAccount.UpdateEmployeeAccount;
import com.model.entity.Account;
import com.model.entity.Role;
import com.service.AccountService;
import com.service.RoleService;
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
        createEmployeeAccount.setDeleted(true);
        createEmployeeAccount.setTotalPoint(0);
        accountService.createEmployeeAccount(createEmployeeAccount);
       Account account = accountService.findAccountByEmployeeName(createEmployeeAccount.getAccountCode());
        accountService.createAccountRole(account.getId(),2);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
    @PostMapping("/check-email")
    public boolean checkEmail(@RequestBody String email){
        return accountService.checkEmail(email);
    }
    @PostMapping("/check-phone")
    public boolean checkPhone(@RequestBody String phone){
        return accountService.checkPhone(phone);
    }
    @PostMapping("/check-username")
    public boolean checkUsername(@RequestBody String username){
        return accountService.checkUsername(username);
    }
    @PostMapping("/check-accountCode")
    public boolean checkAccountCode(@RequestBody String accountCode){
        System.out.println(accountCode);
        return accountService.checkAccountCode(accountCode);
    }

}
