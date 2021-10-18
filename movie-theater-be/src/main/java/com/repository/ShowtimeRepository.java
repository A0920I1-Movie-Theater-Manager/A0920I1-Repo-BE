package com.repository;

import com.model.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
            "where show_time = ?1 and price_id =?2 limit 1 ", nativeQuery = true)
    Showtime getIdByShowDayAndShowTime(LocalTime show_time, long price_id);

    //HueHV
    @Transactional
    @Modifying
    @Query(value = "insert into showtime(show_time, price_id) values(?1, ?2)", nativeQuery = true)
    void addShowTime(LocalTime showTime, long price_id);

    //HueHV
    @Transactional
    @Modifying
    @Query(value = "update showtime set show_time=?1, price_id=?2 where id=?3", nativeQuery = true)
    void updateShowTime(LocalTime showTime, long price_id, long id);
}
