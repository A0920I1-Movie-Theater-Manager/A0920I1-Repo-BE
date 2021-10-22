package com.service.impl;

import com.model.dto.AccountMemberDTO;
import com.model.dto.Viet.AccountUserDTO;
import com.model.dto.Viet.ManagerBooking;
import com.model.entity.Account;
import com.repository.AccountRepository;
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
        public List<Account> listAccountByCodeEmployee () {
            return accountRepository.listAccountByAccountCodeEmployee();
        }

        @Override
        public List<Account> findAllMember () {
            return accountRepository.findAllMember();
        }

        @Override
        public void updateMember (AccountMemberDTO accountMemberDTO,long id){
            accountRepository.updateMember(accountMemberDTO.getAccountCode(), accountMemberDTO.getAddress(), accountMemberDTO.getBirthday(),
                    accountMemberDTO.getEmail(), accountMemberDTO.getFullname(), accountMemberDTO.getGender(), accountMemberDTO.getIdCard(),
                    accountMemberDTO.getImageUrl(), accountMemberDTO.getPassword(), accountMemberDTO.getPhone(), accountMemberDTO.getUsername(),
                    id);
        }
        @Override
        public void createMember (AccountMemberDTO accountMemberDTO){
            accountRepository.createMember(accountMemberDTO.getAccountCode(), accountMemberDTO.getAddress(), accountMemberDTO.getBirthday(),
                    accountMemberDTO.isDeleted(), accountMemberDTO.getEmail(), accountMemberDTO.getFullname(), accountMemberDTO.getGender(), accountMemberDTO.getIdCard(),
                    accountMemberDTO.getImageUrl(), accountMemberDTO.getPassword(), accountMemberDTO.getPhone(), accountMemberDTO.getTotalPoint(), accountMemberDTO.getUsername());
        }
        @Override
        public void deleteMember ( long id){
            accountRepository.deleteMember(id);
        }
        @Override
        public Account findByIdMember ( long id){
            return accountRepository.findByIdMember(id);
        }
        @Override
        public List<Account> findByNameMember (String name){
            return accountRepository.searchNameMember(name);
        }
        @Override
        public boolean checkEmailMember (String email){
            return accountRepository.existsByEmail(email);
        }
        @Override
        public boolean checkPhoneMember (String phone){
            return accountRepository.existsByPhone(phone);
        }
        @Override
        public boolean checkUsernameMember (String username){
            return accountRepository.existsByUsername(username);
        }
    }
