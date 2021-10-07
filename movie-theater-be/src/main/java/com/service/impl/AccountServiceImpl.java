package com.service.impl;


import com.model.dto.AccountDTO;
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
    public void updateMember(AccountDTO accountDTO, long id) {
        accountRepository.updateMember(accountDTO.getAccountCode(),accountDTO.getAddress(),accountDTO.getBirthday(),
                accountDTO.getEmail(),accountDTO.getFullname(),accountDTO.getGender(),accountDTO.getIdCard(),
                accountDTO.getImageUrl(),accountDTO.getPassword(),accountDTO.getPhone(),accountDTO.getUsername(),
                id);
    }

    @Override
    public void createMember(AccountDTO accountDTO) {
        accountRepository.createMember(accountDTO.getAccountCode(),accountDTO.getAddress(),accountDTO.getBirthday(),accountDTO.getDeleted(),
                accountDTO.getEmail(),accountDTO.getFullname(),accountDTO.getGender(),accountDTO.getIdCard(),accountDTO.getImageUrl(),
                accountDTO.getPassword(),accountDTO.getPhone(),accountDTO.getTotalPoint(),accountDTO.getUsername());
    }

    @Override
    public void deleteMember(long id) {
//        accountRepository.deleteMemberMovie(id);
//        accountRepository.deleteMemberComment(id);
//        accountRepository.deleteMemberRole(id);
        accountRepository.deleteMember(id);
    }

    @Override
    public Account findByIdMember(long id) {
        return accountRepository.findByIdMember(id);
    }


}

