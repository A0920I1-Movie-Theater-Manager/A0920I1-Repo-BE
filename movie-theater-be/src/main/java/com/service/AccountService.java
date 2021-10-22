package com.service;

import com.model.dto.AccountMemberDTO;
import com.model.entity.Account;
import java.util.List;


public interface AccountService {
    //HueHV
    List<Account> listAccountByCodeEmployee();
    List<Account> findAllMember();
    void updateMember(AccountMemberDTO accountMemberDTO, long id);
    void createMember(AccountMemberDTO accountMemberDTO);
    void deleteMember(long id);
    Account findByIdMember(long id);
    List<Account> findByNameMember(String name);
    boolean checkEmailMember(String email);
    boolean checkPhoneMember(String phone);
    boolean checkUsernameMember(String username);
}
