package com.controller;

import com.model.dto.employeeAccount.UpdateEmployeeAccount;
import com.model.entity.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin("http://localhost:4200")
public class AccountController {
    @Autowired
    private AccountService accountService ;

    @GetMapping("/list")
    public ResponseEntity<List<Account>> getAllAccountEmployee() {
        List<Account> listEmployeeDTOS = accountService.getAllEmployeeAccount();
        if (listEmployeeDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listEmployeeDTOS, HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") long id) {
        System.out.println("success!");
        Account account = accountService.getAccountById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping("account")
    public ResponseEntity<?> update(@RequestBody UpdateEmployeeAccount updateEmployeeAccount) {
        accountService.updateEmployeeAccount(updateEmployeeAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
