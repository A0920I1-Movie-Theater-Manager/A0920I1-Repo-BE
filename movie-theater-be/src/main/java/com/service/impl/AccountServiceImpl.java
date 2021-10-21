package com.service.impl;

import com.dto.Viet.AccountUserDTO;
import com.dto.Viet.ManagerBooking;
import com.entity.Account;
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
    public Account findAccountUpdateById(long id) {
       return accountRepository.findAccountUpdateById(id);

    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void updateAccount(AccountUserDTO accountUserDTO) {
        accountRepository.updateAccountUser(accountUserDTO.getAccountCode(), accountUserDTO.getAddress(),accountUserDTO.getBirthday(),accountUserDTO.getEmail(),accountUserDTO.getFullname(),accountUserDTO.getGender(),accountUserDTO.getIdCard(),accountUserDTO.getImageUrl(),accountUserDTO.getPassword(),accountUserDTO.getPhone(),accountUserDTO.getTotalPoint(),accountUserDTO.getUsername(),accountUserDTO.getId());
    }

    @Override
    public List<ManagerBooking> ManagerTickets() {
        return accountRepository.ManagerTickets();
    }

    @Override
    public List<ManagerBooking> findAllBookByIdAccount(String idAccount) {
        return accountRepository.findAllFeedbackBookByIdAccount(idAccount);
    }

    @Override
    public void changePassword(AccountUserDTO accountUserDTO) {
        accountRepository.changePassword(accountUserDTO.getAccountCode(), accountUserDTO.getAddress(),accountUserDTO.getBirthday(),accountUserDTO.getEmail(),accountUserDTO.getFullname(),accountUserDTO.getGender(),accountUserDTO.getIdCard(),accountUserDTO.getImageUrl(),accountUserDTO.getPassword(),accountUserDTO.getPhone(),accountUserDTO.getTotalPoint(),accountUserDTO.getUsername(),accountUserDTO.getId());

    }
}
