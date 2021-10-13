package com.model.dto.hue;

import java.time.LocalTime;

public class ShowTimesDTO {
    private long id;

    private LocalTime show_time;
    private long price_id;

    private long movie_id;

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getShow_time() {
        return show_time;
    }

    public void setShow_time(LocalTime show_time) {
        this.show_time = show_time;
    }

    public long getPrice_id() {
        return price_id;
    }

    public void setPrice_id(long price_id) {
        this.price_id = price_id;
    }
}
