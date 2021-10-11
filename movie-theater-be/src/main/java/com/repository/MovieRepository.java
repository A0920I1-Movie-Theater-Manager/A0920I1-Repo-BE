package com.repository;

import com.model.dto.TopFiveMovieDTO;
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

    //    TuHC - tim kiem phim theo ten phim, dao dien, dien vien va phim dang duoc chieu
    @Query(value = "SELECT * FROM movietheater.movie " +
            "where (movie.title like %:keyword% " +
            "or movie.cast like %:keyword% " +
            "or movie.director like %:keyword%) " +
            "and (:today between showing_from and showing_to)", nativeQuery = true)
    List<Movie> searchMovie(@Param("keyword") String keyword, @Param("today") LocalDate today);

////    TuHC - top 5 phim xem nhieu
//    @Query(value = "SELECT movie.id as id, movie.cast as cast, movie.content as content, movie.director as director, " +
//            "movie.is3d as is3D, movie.production as production, movie.rated as rated, movie.release_date as releaseDate, " +
//            "movie.running_time as runningTime, movie.showing_from as showingFrom, movie.showing_to as showingTo, " +
//            "movie.title as title, movie.trailer_url as trailerUrl, movie.account_id as accountId, count(movie.id) as viewer " +
//            "FROM movietheater.movie " +
//            "inner join movie_showtime on movie_showtime.movie_id = movie.id " +
//            "inner join showtime on showtime.id = movie_showtime.showtime_id " +
//            "inner join screen on screen.showtime_id = showtime.id " +
//            "inner join seat on seat.screen_id = screen.id " +
//            "inner join booking_seat on booking_seat.seat_id = seat.id " +
//            "group by movie.id " +
//            "order by viewer desc " +
//            "limit 5", nativeQuery = true)
//    List<TopFiveMovieDTO> listTopFiveMovie();

//    TuHC- top 5 movie
    @Query(value = "SELECT movie.id, movie.cast, movie.content, movie.director, " +
            "movie.is3d, movie.production, movie.rated, movie.release_date, " +
            "movie.running_time, movie.showing_from, movie.showing_to, " +
            "movie.title, movie.trailer_url, movie.account_id " +
            "FROM movietheater.movie " +
            "inner join movie_showtime on movie_showtime.movie_id = movie.id " +
            "inner join showtime on showtime.id = movie_showtime.showtime_id " +
            "inner join screen on screen.showtime_id = showtime.id " +
            "inner join seat on seat.screen_id = screen.id " +
            "inner join booking_seat on booking_seat.seat_id = seat.id " +
            "group by movie.id " +
            "order by count(movie.id)desc " +
            "limit 5", nativeQuery = true)
    List<Movie> listTopFiveMovie();
}
