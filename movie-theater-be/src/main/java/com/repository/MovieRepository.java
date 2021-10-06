package com.repository;

import com.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //    TuHC - lay danh sach phim dang chieu
    @Query(value = "SELECT * FROM movietheater.movie " +
            "where :today >= showing_from and :today <= showing_to", nativeQuery = true)
    List<Movie> findAllMovieShowing(@Param("today") LocalDate today);

    //    TuHC - lay danh sach phim sap chieu
    @Query(value = "SELECT * FROM movietheater.movie " +
            "where :today < showing_from", nativeQuery = true)
    List<Movie> findAllMovieComingSoon(@Param("today") LocalDate today);

    // TuHC - chi tiet phim
    @Query(value = "SELECT * FROM movietheater.movie where id = :id", nativeQuery = true)
    Movie findMovieById(@Param("id") long id);
}
