package com.service;

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
}
