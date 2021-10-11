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

    @GetMapping("employee-account-list")
    public ResponseEntity<List<Account>> getAllEmployee() {
        List<Account> listEmployeeDTOS = accountService.getAllEmployeeAccount();
        if (listEmployeeDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listEmployeeDTOS, HttpStatus.OK);
        }
    }

    @GetMapping("search")
    public ResponseEntity<List<Account>> searchMeetingRoomByName(@RequestParam(required = false) String search  ){
        List<Account> accounts = accountService.findEmployeeAccountByFullNameOrAccountCode(search);
        return new ResponseEntity<>( accounts,HttpStatus.OK);
    }

    @GetMapping("employee-account/{id}")
    public ResponseEntity<Account> getEmployeeById(@PathVariable("id") long id) {
        System.out.println("success!");
        Account account = accountService.getAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping("employee-account-edit")
    public ResponseEntity<?> updateEmployee(@RequestBody UpdateEmployeeAccount updateEmployeeAccount) {
        accountService.updateEmployeeAccount(updateEmployeeAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="employee-account-create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeAccount createEmployeeAccount){
        createEmployeeAccount.setDeleted(true);
        createEmployeeAccount.setTotalPoint(0);
        accountService.createEmployeeAccount(createEmployeeAccount);
       Account account = accountService.findAccountByEmployeeName(createEmployeeAccount.getAccountCode());
        accountService.createAccountRole(account.getId(),2);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping(value = "employee-account-delete/{id}")
    public ResponseEntity<?> deleteByEmployeeId(@PathVariable Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Không có tài khoản này !");
        }
        accountService.deleteEmployeeAccountById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
