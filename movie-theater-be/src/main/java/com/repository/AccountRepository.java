package com.repository;

import com.model.dto.Viet.ManagerBooking;
import com.model.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;


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

<<<<<<< HEAD
>>>>>>> 54fa62ca00214a34a99419677dcb14df49902b06
=======
    //Viet hiển thị account theo id
    @Transactional
    @Query(value = "SELECT * FROM account where id = ?1", nativeQuery = true)
    Account findAccountUpdateById(Long id);

    //Việt cập nhật thông tin người dùng
    @Transactional
    @Query(value = "SELECT * FROM account ", nativeQuery = true)
    List<Account> findAll();

    @Transactional
    @Modifying
    @Query(value = "  UPDATE account  SET account_code = ?1, address = ?2, birthday = ?3,email = ?4,fullname = ?5, gender = ?6,id_card = ?7,image_url = ?8,password = ?9,phone= ?10, total_point =?11,username=?12 WHERE id = ?13", nativeQuery = true)
    void updateAccountUser(String accountCode, String address, LocalDate birthday, String email, String fullname, String gender, String idCard, String imageUrl, String password, String phone, int totalPoint, String username, long id);

    //Việt quản lý vé người dùng
    @Transactional
    @Modifying
    @Query(value = "SELECT movie.id,movie.title,booking.day_time_booking,booking.total_price,booking.received\n" +
            "FROM movie\n" +
            "INNER JOIN booking\n" +
            "ON movie.account_id = booking.account_id\n" +
            "INNER JOIN `account`\n" +
            "ON `account`.id = booking.account_id\n" +
            "group by  movie.id, movie.title", nativeQuery = true)
    List<ManagerBooking> ManagerTickets();
//Việt lấy danh sách theo account id

    @Query(
            value = "select movie.id, movie.account_id, movie.title,  booking.day_time_booking,booking.total_price , booking.received from movie\n" +
                    "inner join booking\n" +
                    "on movie.account_id= booking.account_id\n" +
                    "where  movie.account_id =:idAccount",

            nativeQuery = true
    )
    List<ManagerBooking> findAllFeedbackBookByIdAccount(@Param("idAccount") String idAccount);

    // Việt đổi mật khẩu
    @Transactional
    @Modifying
    @Query(value = "  UPDATE account  SET account_code = ?1, address = ?2, birthday = ?3,email = ?4,fullname = ?5, gender = ?6,id_card = ?7,image_url = ?8,password = ?9,phone= ?10, total_point =?11,username=?12 WHERE id = ?13", nativeQuery = true)
    void changePassword(String accountCode, String address, LocalDate birthday, String email, String fullname, String gender, String idCard, String imageUrl, String password, String phone, int totalPoint, String username, long id);




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
    void createEmployeeAccount(String accountCode, String address, LocalDate birthday, String email, String fullname, String gender, String idCard, String imageUrl, String password, String phone, String username, boolean deleted, int totalPoint);

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
>>>>>>> 741a35df26d2524d322d67b744e52f5a620c92bd

    //HoangLV
    boolean existsAccountsByAccountCode(String accountCode);
}