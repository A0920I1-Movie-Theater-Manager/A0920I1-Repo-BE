package com.controller;

import com.model.dto.AccountDTO;
import com.model.entity.Account;
import com.repository.AccountRepository;
import com.service.AccountService;
import org.omg.CORBA.RepositoryIdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
@CrossOrigin("http://localhost:4200")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/list-member")
    public ResponseEntity<List<Account>> getAllMember() {
        List<Account> accounts = accountService.findAllMember();
        if(accounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity <List<Account>>(accounts,HttpStatus.OK);
    }

    @PutMapping("/update-member/{id}")
    public ResponseEntity<?> updateMember(@PathVariable("id") long id , @RequestBody AccountDTO accountDTO){
       accountService.updateMember(accountDTO,id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create-member")
    public ResponseEntity<AccountDTO> createMember(@RequestBody AccountDTO accountDTO ){
        accountService.createMember(accountDTO);
        return new ResponseEntity<AccountDTO>(HttpStatus.CREATED);
    }
    @GetMapping("/findById-member/{id}")
    public ResponseEntity<Account> getIdMember(@PathVariable ("id") long id,@RequestBody Account account){
       Account accounts = accountService.findByIdMember(id);
        return new ResponseEntity<Account>(accounts,HttpStatus.OK);
    }
    @DeleteMapping("delete-member/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") long id){
        accountService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
