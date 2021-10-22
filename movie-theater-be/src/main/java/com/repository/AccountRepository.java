package com.repository;

import com.dto.Viet.ManagerBooking;
import com.entity.Account;

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
