package com.repository;

import com.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    // Danh sách nhân viên (HoangLV)
    @Query(value = "select * from account inner join account_role on account.id = account_role.id " +
            "where account.deleted = 1 and account_role.role_id = 2 ", nativeQuery = true)
    List<Account> getAllAccountEmployee();

    // Lấy thông tin nhân viên theo id (HoangLV)
    @Query(value = "select * from account inner join account_role on account.id = account_role.id " +
            "where account.deleted = 1 and account_role.role_id = 2 and account.id = ?1 ", nativeQuery = true)
    Account getAccountById(long id);

    @Transactional
    @Modifying
    @Query(value = "update `account` as ac set ac.username = ?1 , ac.`password` = ?2 , ac.fullname = ?3,ac.birthday = ?4 ,ac.gender = ?.5 ,ac.email = ?6 , ac.id_card = ?7 ,ac.phone = ?8 ,ac.address = ?9 ,ac.image_url = ?10 , ac.account_code = ?11 where ac.id = ?12;", nativeQuery = true)
    void updateEmployeeAccount(String username, String password, String fullname, LocalDate birthday, String gender, String email, String idCard, String phone, String address, String imageUrl, String accountCode, long id);
}