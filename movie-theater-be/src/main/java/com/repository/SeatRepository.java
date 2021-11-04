package com.repository;


import com.model.dto.SeatDTO;
import com.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    //    TuHC - lay ghe theo phim va gio chieu
    @Query(value = "SELECT seat.id, seat.name, seat.price, seat.vip, seat.screen_id \n" +
            "FROM movietheater.seat \n" +
            "inner join screen on screen.id = seat.screen_id\n" +
            "inner join showtime on showtime.id = screen.showtime_id\n" +
            "inner join movie_showtime on movie_showtime.showtime_id = showtime.id\n" +
            "inner join movie on movie.id = movie_showtime.movie_id\n" +
            "where movie.id = :movieId and showtime.id = :showtimeId", nativeQuery = true)
    List<Seat> findAllSeatByMovieAndShowtime(@Param("movieId") long movieId, @Param("showtimeId") long showtimeId);

    //    TuHC - lay ghe theo ten va gio chieu
    @Query(value = "SELECT seat.*, price.price as basePrice, movie.title, showtime.show_time as showtime\n" +
            "FROM movietheater.seat\n" +
            "inner join screen on screen.id = seat.screen_id\n" +
            "inner join showtime on showtime.id = screen.showtime_id\n" +
            "inner join price on price.id = showtime.price_id " +
            "inner join movie_showtime on movie_showtime.showtime_id = showtime.id\n" +
            "inner join movie on movie.id = movie_showtime.movie_id " +
            "where seat.name = :seatName and showtime.id = :showtimeId and movie.id = :movieId", nativeQuery = true)
    SeatDTO findSeatBySeatNameAndShowtime(@Param("seatName") String seatName,
                                          @Param("showtimeId") long showtimeId,
                                          @Param("movieId") long movieId);
}
