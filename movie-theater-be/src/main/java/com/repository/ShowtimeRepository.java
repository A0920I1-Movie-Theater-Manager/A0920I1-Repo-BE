package com.repository;

import com.model.dto.ShowTimeDTO;
import com.model.entity.Showtime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    @Query(value = "select showtime.id as id, movie.title as title, screen.name as screenName, showtime.show_day as showDay," +
            " showtime.show_time as showTime, movie.is3D as is3d, price.price as price from `showtime` \n" +
            "join movie_showtime on movie_showtime.showtime_id = showtime.id\n" +
            "join movie on movie_showtime.movie_id = movie.id\n" +
            "join screen on showtime.id = screen.showtime_id\n" +
            "join price on showtime.price_id = price.id\n" +
            "order by showtime.show_day desc, showtime.show_time desc", nativeQuery = true)
    Page<ShowTimeDTO>getAllShowTime(Pageable pageable);
    @Query(value = "select  showtime.id, movie.title, screen.name, showtime.show_day, showtime.show_time, movie.is3D, price.price from showtime\n" +
            "join movie_showtime on movie_showtime.showtime_id = showtime.id\n" +
            "join movie on movie_showtime.movie_id = movie.id\n" +
            "join screen on showtime.id = screen.showtime_id\n" +
            "join price on showtime.price_id = price.id\n" +
            "where movie.title like %1%", nativeQuery = true)
    Page<ShowTimeDTO> searchByName(String name, Pageable pageable);
}
