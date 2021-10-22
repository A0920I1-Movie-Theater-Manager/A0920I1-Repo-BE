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
public interface AccountRepository extends JpaRepository<Account, Long> {


    //HueHV
    @Query(value = "select * from account where account_code like 'NV%';", nativeQuery = true)
    List<Account> listAccountByAccountCodeEmployee();

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



}
