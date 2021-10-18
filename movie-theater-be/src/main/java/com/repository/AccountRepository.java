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


    // Lấy thông tin người dùng theo họ và tên hoặc mã nhân viên
    @Query(value = "select * from `account`inner join account_role on account.id = account_role.id where account.deleted = 1 and account_role.role_id = 2 and account.fullname like %?1% or  account.account_code like %?1%", nativeQuery = true)
    List<Account> findEmployeeAccountByFullNameOrAccountCode(String search);

    //Sửa thông tin nhân viên (HoangLV)
    @Transactional
    @Modifying
    @Query(value = "update `account` as ac set ac.username = ?1 , ac.`password` = ?2 , ac.fullname = ?3, ac.birthday = ?4 , ac.gender = ?5 , ac.email = ?6 , ac.id_card = ?7 , ac.phone = ?8 ,ac.address = ?9 , ac.image_url = ?10 , ac.account_code = ?11 where ac.id = ?12 ;", nativeQuery = true)
    void updateEmployeeAccount(String username, String password, String fullname, LocalDate birthday, String gender, String email, String idCard, String phone, String address, String imageUrl, String accountCode, long id);


    //Thêm mới nhân viên
    @Transactional
    @Modifying
    @Query(value = "insert into account(`account_code`, `address`, `birthday`, `email`, `fullname`, `gender`, `id_card`, `image_url`, `password`, `phone`, `username`,`deleted`,`total_point`) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8,?9,?10,?11,?12,?13)", nativeQuery = true)
    void createEmployeeAccount(String accountCode, String address ,LocalDate birthday,String email,String fullname,String gender,String idCard,String imageUrl,String password,String phone,String username ,boolean deleted,int totalPoint);

    //Thêm role cho nhân viên(HoangLV)
    @Transactional
    @Modifying
    @Query(value = "insert into account_role(account_id, role_id) values (?1, ?2)", nativeQuery = true)
    void createAccountRole(long accountId, long roleId);

    //Lấy nhân viên theo mã nhân viên(HoangLV)
    @Query(value = "select * from `account` where account_code = ?1 ", nativeQuery = true)
    Account findAccountByEmployeeName(String keyWord);


    //Xóa thông tin nhân viên HoangLV
    @Transactional
    @Modifying
    @Query(value = "update `account` set account.deleted = 0 where account.id=?1", nativeQuery = true)
    void deleteEmployeeAccountById(Long id);


}