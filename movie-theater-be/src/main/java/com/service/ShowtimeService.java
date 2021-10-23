package com.service;

import com.model.dto.ShowTimeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.model.entity.Showtime;
import java.time.LocalTime;
import java.util.List;

public interface ShowtimeService {
    //HueHV
    List<Showtime> listShowTimes();

    //HueHV
    Showtime getIdByShowDayAndShowTime(LocalTime show_time, long price_id);

    //HueHV
    void joinTableMovieAndShowtime(long movie_id, long showtime_id);

    //HueHV
    void addShowTimes(LocalTime showTime,long price_id);

    //HueHV
    void updateShowTimes(LocalTime showTime,long price_id, long id);

    //    TuHC
    List<Showtime> findShowtimeByMovieId(long id);

    Page<ShowTimeDTO> getAllShowTime(Pageable pageable);
    Page<ShowTimeDTO> searchByName(String name, Pageable pageable);
}
