package com.repository;

import com.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    List<Movie> findAllMovie();


    @Query(value = "select * from movie where id = ?1", nativeQuery = true)
    Movie findMovieById(long id);

    @Transactional
    @Modifying
    @Query(value = "insert into movie(title, showing_From, showing_To, cast, director, release_Date, rated, running_Time,production, trailer_Url, content, is3D, account_Id) " +
            " values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13)", nativeQuery = true)
    void createMovie(String title, LocalDate showing_From, LocalDate showing_To, String cast, String director, LocalDate release_Date, String rated, int running_Time,
                     String production,String trailer_Url, String content, boolean is3D, long account_Id);

    @Transactional
    @Modifying
    @Query(value = "update movie set title = ?1, showing_From = ?2, showing_To = ?3, cast = ?4, director = ?5, release_Date = ?6, rated = ?7, running_Time = ?8,  " +
            "production = ?9, trailer_Url = ?10, content = ?11, is3D = ?12, account_Id = ?13 where movie.id = ?14 ", nativeQuery = true)
    void updateMovie(String title, LocalDate showing_From, LocalDate showing_To, String cast, String director, LocalDate release_Date, String rated, int running_Time,
                     String production,String trailer_Url, String content, boolean is3D, long account_Id, long id);
}

