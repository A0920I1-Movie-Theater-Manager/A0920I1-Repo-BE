package com.service;

import com.model.dto.AccountDTO;
import com.model.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService {

    List<Account> findAllMember();
    void updateMember(AccountDTO accountDTO,long id);
    void createMember(AccountDTO accountDTO);
    void deleteMember(long id);
    Account findByIdMember(long id);
    List<Account> findByNameMember(String name);
}
