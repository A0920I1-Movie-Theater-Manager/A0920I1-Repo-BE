package com.repository;

import com.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    //AnhLT
    Account findByEmail(String email);
    //AnhLT
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByUsername(String username);



    //HueHV
    @Query(value = "select * from account where account_code like 'NV%';", nativeQuery = true)
    List<Account> listAccountByAccountCodeEmployee();

    //AnhLT
    Account findAccountByUsername(String username);

}
