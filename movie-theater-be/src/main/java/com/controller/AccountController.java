package com.controller;

import com.model.dto.AccountMemberDTO;
import com.model.entity.Account;
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

    @Autowired
    AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //PhapNT-Hiển thị danh sách thành viên.
    @GetMapping("/list-member")
    public ResponseEntity<List<Account>> getAllMember() {
        List<Account> accounts = accountService.findAllMember();
        if(accounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity <List<Account>>(accounts,HttpStatus.OK);
    }
//PhapNT- Chỉnh sửa thành viên
    @PutMapping("/update-member/{id}")
    public ResponseEntity<?> updateMember(@PathVariable("id") long id , @RequestBody AccountMemberDTO accountMemberDTO){
        accountMemberDTO.setPassword(passwordEncoder.encode(accountMemberDTO.getPassword()));
       accountService.updateMember(accountMemberDTO,id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
//PhapNT- Thêm thành viên
    @PostMapping("/create-member")
    public ResponseEntity<?> createMember(@RequestBody AccountMemberDTO accountMemberDTO){
//        if (accountService.existsByEmailMember(accountMemberDTO.getEmail())!= null) {
//            return ResponseEntity.badRequest().body("Email đã được đăng ký!!!");
//        }
//        if (accountService.existsByUsernameMember(accountMemberDTO.getUsername()) != null) {
//            return ResponseEntity.badRequest().body("Tên đăng nhập đã được đăng ký!!!");
//        }
//        if (accountService.existsByPhoneMember(accountMemberDTO.getPhone()) != null) {
//            return ResponseEntity.badRequest().body("Số điện thoại đã được đăng ký!!!");
//        }
        passwordEncoder.encode(accountMemberDTO.getPassword());
        accountService.createMember(accountMemberDTO);
        return new ResponseEntity<AccountMemberDTO>(HttpStatus.CREATED);
    }
    //PhapNT-
    @GetMapping("/public/findById-member/{id}")
    public ResponseEntity<Account> getIdMember(@PathVariable ("id") long id){
       Account accounts = accountService.findByIdMember(id);
        System.out.println();
        return new ResponseEntity<Account>(accounts,HttpStatus.OK);
    }
    @DeleteMapping("delete-member/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") long id){
        accountService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("searchName-member")
    public ResponseEntity<List<Account>> searchNameMember(@RequestParam("name") String name){
      List<Account> accounts = accountService.findByNameMember(name);
        return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    }
    @PostMapping("/check-emailMember")
    public boolean checkEmailMember(@RequestBody String email){
        return accountService.checkEmailMember(email);

    }
    @PostMapping("/check-phoneMember")
    public boolean checkPhoneMember(@RequestBody String phone){
        return accountService.checkPhoneMember(phone);
    }
    @PostMapping("/check-usernameMember")
    public boolean checkUsernameMember(@RequestBody String username){
        return accountService.checkUsernameMember(username);
    }
}
