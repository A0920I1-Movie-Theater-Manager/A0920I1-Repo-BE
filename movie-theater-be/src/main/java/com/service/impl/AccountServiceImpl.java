package com.service.impl;


import com.model.dto.AccountMemberDTO;
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

    @Override
    public List<Account> findAllMember() {
        return accountRepository.findAllMember();
    }

    @Override
    public void updateMember(AccountMemberDTO accountMemberDTO, long id) {
        accountRepository.updateMember(accountMemberDTO.getAccountCode(), accountMemberDTO.getAddress(), accountMemberDTO.getBirthday(),
                accountMemberDTO.getEmail(), accountMemberDTO.getFullname(), accountMemberDTO.getGender(), accountMemberDTO.getIdCard(),
                accountMemberDTO.getImageUrl(), accountMemberDTO.getPassword(), accountMemberDTO.getPhone(), accountMemberDTO.getUsername(),
                id);
    }
    @Override
    public void createMember(AccountMemberDTO accountMemberDTO) {
        accountRepository.createMember(accountMemberDTO.getAccountCode(), accountMemberDTO.getAddress(), accountMemberDTO.getBirthday(),
               accountMemberDTO.isDeleted(), accountMemberDTO.getEmail(), accountMemberDTO.getFullname(), accountMemberDTO.getGender(), accountMemberDTO.getIdCard(),
                accountMemberDTO.getImageUrl(), accountMemberDTO.getPassword(), accountMemberDTO.getPhone(), accountMemberDTO.getTotalPoint(), accountMemberDTO.getUsername());
    }
    @Override
    public void deleteMember(long id) {
        accountRepository.deleteMember(id);
    }
    @Override
    public Account findByIdMember(long id) {
        return accountRepository.findByIdMember(id);
    }
    @Override
    public List<Account> findByNameMember(String name) {
        return accountRepository.searchNameMember(name);
    }
    @Override
    public boolean checkEmailMember(String email) {
        return accountRepository.existsByEmail(email);
    }
    @Override
    public boolean checkPhoneMember(String phone) {
        return accountRepository.existsByPhone(phone);
    }
    @Override
    public boolean checkUsernameMember(String username) {
        return accountRepository.existsByUsername(username);
    }
}

