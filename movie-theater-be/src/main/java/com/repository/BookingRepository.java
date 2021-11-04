package com.repository;

import com.model.entity.Booking;
;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    //    TuHC - them vao booking
    @Query(value = "INSERT INTO movietheater.booking (booking_code, point, received, total_price, account_id, payment_id, promotion_id) " +
            "VALUES (:bookingCode, :point, :received , :totalPrice, :accountId, :paymentId, :promotionId)", nativeQuery = true)
    void saveBooking(@Param("bookingCode") String bookingCode,
                     @Param("point") int point,
                     @Param("received") int received,
                     @Param("totalPrice") double totalPrice,
                     @Param("accountId") long accountId,
                     @Param("paymentId") long paymentId,
                     @Param("promotionId") long promotionId);

    //    TuHC - them vao booking seat
    @Query(value = "INSERT INTO movietheater.booking_seat (booking_id, seat_id) VALUES (:bookingId, :seatId)", nativeQuery = true)
    void saveBookingSeat(@Param("bookingId") long bookingId, @Param("seatId") long seatId);
}
