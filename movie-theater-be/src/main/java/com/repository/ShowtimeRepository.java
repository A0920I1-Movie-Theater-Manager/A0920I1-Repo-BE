package com.repository;

import com.model.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
//    TuHC - lay showtime bang movieid
    @Query(value = "SELECT showtime.id, showtime.show_time, showtime.price_id " +
            "FROM movietheater.showtime " +
            "INNER JOIN movie_showtime ON movie_showtime.showtime_id = showtime.id " +
            "INNER JOIN movie ON movie.id = movie_showtime.movie_id " +
            "WHERE movie.id = :id", nativeQuery = true)
    List<Showtime> findShowtimeByMovieId(@Param("id") long id);
}
