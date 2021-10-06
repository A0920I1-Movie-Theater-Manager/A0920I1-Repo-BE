package com.repository;

import com.model.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    //HueHV
    @Query(value = "select * from showtime", nativeQuery = true)
    List<Showtime> listShowTime();

    //HueHV
    @Transactional
    @Modifying
    @Query(value = "insert into movie_showtime (movie_id, showtime_id) values (?1, ?2);", nativeQuery = true)
    void joinTableMovieAndShowtime(long movie_id, long showtime_id);

    //HueHV
    @Query(value = "select * " +
            "from showtime " +
            "where show_day = ?1 and show_time = ?2 limit 1 ", nativeQuery = true)
    Showtime getIdByShowDayAndShowTime(LocalDate show_date, LocalTime show_time);

    //HueHV
    @Transactional
    @Modifying
    @Query(value = "insert into showtime(show_time, show_day, price_id) values(?1, ?2, ?3)", nativeQuery = true)
    void addShowTime(LocalTime showTime, LocalDate showDay, long price_id);
}
