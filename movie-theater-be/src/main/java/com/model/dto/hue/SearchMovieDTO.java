package com.model.dto.hue;

import java.time.LocalDate;

public class SearchMovieDTO {
    private String title;
    private String production;
    private LocalDate releaseDate;
    private String is3D;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getIs3D() {
        return is3D;
    }

    public void setIs3D(String is3D) {
        this.is3D = is3D;
    }
}
