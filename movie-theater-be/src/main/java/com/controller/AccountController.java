package com.controller;

import com.dto.Viet.AccountUserDTO;
import com.dto.Viet.ManagerBooking;
import com.entity.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin("http://localhost:4200")
public class AccountController {
    private @Autowired
    AccountService accountService;
    private @Autowired
    PasswordEncoder passwordEncoder;


    //ViệtNT lấy thông tin tài khoản bằng id 06/10/2021

    @GetMapping(value = "/accountFindById/{id}")
    public ResponseEntity<Account> getUserById(@PathVariable long id) {
        System.out.print(id);
        Account account = accountService.findAccountUpdateById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    //VietNT lấy tất cả User 08/10/2021
    @GetMapping(value = "/account")
    public ResponseEntity<List<Account>> getAllUser() {

        List<Account> accountList = accountService.findAll();

        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(accountList, HttpStatus.OK);
        }
    }

    //VietNT Update User
    @PutMapping(value = "/public/update/{id}")
    public ResponseEntity<AccountUserDTO> updateAccountUser(@PathVariable("id") long id, @RequestBody AccountUserDTO accountUserDTO) {
        Account account = accountService.findAccountUpdateById(id);
        System.out.println(id);

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
           accountUserDTO.setPassword( passwordEncoder.encode(accountUserDTO.getPassword())) ;

            accountService.updateAccount(accountUserDTO);


            return new ResponseEntity<>(accountUserDTO, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/account/booking")
    public ResponseEntity<List<ManagerBooking>> managerTickets() {

        List<ManagerBooking> movieList = accountService.ManagerTickets();

        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(movieList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/account/booking/{idAccount}")
    public List<ManagerBooking> getAllFeedbackByIdAccount(@PathVariable("idAccount") String idAccount) {
        List<ManagerBooking> managerBookingList = accountService.findAllBookByIdAccount(idAccount);
        return managerBookingList;

    }

    @PutMapping(value = "/public/changePassword/{id}")
    public ResponseEntity<AccountUserDTO> changePassWord(@PathVariable("id") long id, @RequestBody AccountUserDTO accountUserDTO) {
        Account account = accountService.findAccountUpdateById(id);
        System.out.println(id);

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            accountService.changePassword(accountUserDTO);

            return new ResponseEntity<>(accountUserDTO, HttpStatus.OK);
        }
    }
}
