package com.service;

<<<<<<< HEAD

=======
import com.model.dto.AccountMemberDTO;
>>>>>>> 54fa62ca00214a34a99419677dcb14df49902b06
import com.model.entity.Account;

import java.util.List;

public interface AccountService {
    //HueHV
    List<Account> listAccountByCodeEmployee();
<<<<<<< HEAD

=======
    List<Account> findAllMember();
    void updateMember(AccountMemberDTO accountMemberDTO, long id);
    void createMember(AccountMemberDTO accountMemberDTO);
    void deleteMember(long id);
    Account findByIdMember(long id);
    List<Account> findByNameMember(String name);
    boolean checkEmailMember(String email);
    boolean checkPhoneMember(String phone);
    boolean checkUsernameMember(String username);
>>>>>>> 54fa62ca00214a34a99419677dcb14df49902b06
}
