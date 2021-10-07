package com.repository;

import com.model.dto.AccountDTO;
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

    //PhapNT- Hiển thị danh sách thành viên.
    @Query(value = " select * from  movietheater.account", nativeQuery = true)
            List <Account> findAllMember();


//PhapNT- Chỉnh sửa thành viên.
    @Transactional
    @Modifying
    @Query(value = "update account as a set a.account_code = ?1,  a.address = ?2, a.birthday = ?3 ," +
            " a.email = ?4, a.fullname=?5, a.gender=?6, a.id_card=?7, a.image_url=?8,a.password= ?9," +
            "a.phone = ?10, a.username = ?11 where a.id = ?12", nativeQuery = true)
    void updateMember(String account_code, String address, LocalDate birthday, String email, String fullname, String gender,
                      String idCard, String imageUrl, String password, String phone, String username,long id);
//PhapNT- Thêm mới thành viên.
    @Transactional
    @Modifying
    @Query(value="INSERT INTO `movietheater`.`account` ( `account_code`, `address`, `birthday`, `deleted`," +
            " `email`, `fullname`, `gender`, `id_card`, `image_url`, `password`, `phone`, `total_point`, `username`)" +
            " VALUES (?1, ?2,?3,?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13)",nativeQuery = true)
    void createMember(String account_code,String address,LocalDate birthday, long deleted, String email,String fullname,String gender,
                      String id_card,String imagerUrl,String password,String phone,int totalPoint,String username);
//PhapNT- Xóa thành viên.
    @Transactional
    @Modifying
    @Query(value = "delete from account where id=?1", nativeQuery = true)
    void deleteMember(long id);

    @Transactional
    @Modifying
    @Query(value = "delete from account_role where account_role.account_id=?1", nativeQuery = true)
    void deleteMemberRole(long id);

    @Transactional
    @Modifying
    @Query(value = "delete from comment where comment.account_id=?1", nativeQuery = true)
    void deleteMemberComment(long id);

    @Transactional
    @Modifying
    @Query(value = "delete from movie where movie.account_id=?1", nativeQuery = true)
    void deleteMemberMovie(long id);


    //PhapNT- Chi tiết thành viên.
    @Query(value = "select * from account where account.id= ?1", nativeQuery = true)
    Account findByIdMember(long id);

}
