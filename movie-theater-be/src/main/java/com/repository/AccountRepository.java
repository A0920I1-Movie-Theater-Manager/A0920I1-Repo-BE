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
<<<<<<< HEAD
public interface AccountRepository extends JpaRepository<Account,Long> {
    //AnhLT
    Account findByEmail(String email);
    //AnhLT
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByUsername(String username);


=======
public interface AccountRepository extends JpaRepository<Account, Long> {
>>>>>>> 54fa62ca00214a34a99419677dcb14df49902b06

    //HueHV
    @Query(value = "select * from account where account_code like 'NV%';", nativeQuery = true)
    List<Account> listAccountByAccountCodeEmployee();

<<<<<<< HEAD
    //AnhLT
    Account findAccountByUsername(String username);
=======
    //PhapNT- Kiểm tra email đã tồn tại
// @Query(value = "SELECT email from  movietheater.account where email = ?1", nativeQuery = true)
    boolean existsByEmail(String email);

    //PhapNT-Kiểm tra số đt đã tồn tại
// @Query(value = "SELECT phone from  movietheater.account where phone = ?1", nativeQuery = true)
    boolean existsByPhone(String phone);

    //PhapNT-Kiểm tra tên đăng nhập đã tồn tại
//  @Query(value = "SELECT username from  movietheater.account where username = ?1", nativeQuery = true)
    boolean existsByUsername(String username);


    //PhapNT- Hiển thị danh sách thành viên.
    @Query(value = " select account.* from  movietheater.account where deleted=0", nativeQuery = true)
    List<Account> findAllMember();

    //PhapNT- Chỉnh sửa thành viên.
    @Transactional
    @Modifying
    @Query(value = "update account as a set a.account_code = ?1,  a.address = ?2, a.birthday = ?3 ," +
            " a.email = ?4, a.fullname=?5, a.gender=?6, a.id_card=?7, a.image_url=?8,a.password= ?9," +
            "a.phone = ?10, a.username = ?11 where a.id = ?12", nativeQuery = true)
    void updateMember(String account_code, String address, LocalDate birthday, String email, String fullname, String gender,
                      String idCard, String imageUrl, String password, String phone, String username, long id);

    //PhapNT- Thêm mới thành viên.
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `movietheater`.`account` ( `account_code`, `address`, `birthday`, `deleted`," +
            " `email`, `fullname`, `gender`, `id_card`, `image_url`, `password`, `phone`, `total_point`, `username`)" +
            " VALUES (?1, ?2,?3,?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13)", nativeQuery = true)
    void createMember(String account_code, String address, LocalDate birthday, boolean deleted, String email, String fullname, String gender,
                      String id_card, String imagerUrl, String password, String phone, int totalPoint, String username);

    //PhapNT- Xóa thành viên.
    @Transactional
    @Modifying
    @Query(value = "update `account` set account.deleted = 1 where account.id=?1", nativeQuery = true)
    void deleteMember(long id);

    //PhapNT- Chi tiết thành viên.
    @Query(value = "select * from account where account.id= ?1", nativeQuery = true)
    Account findByIdMember(long id);

    //PhapNT-Tìm Kiếm theo tên
    @Query(value = "select * from account where account.fullname like %?1%", nativeQuery = true)
    List<Account> searchNameMember(String name);

>>>>>>> 54fa62ca00214a34a99419677dcb14df49902b06

}
