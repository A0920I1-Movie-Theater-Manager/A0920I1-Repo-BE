package com.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private LocalDate showingFrom;
    private LocalDate showingTo;
    private String cast;
    private String director;
    private LocalDate releaseDate;
    private String rated;
    private int runningTime;
    private String production;
    private String trailerUrl;
    private String content;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean is3D;

    @ManyToMany(mappedBy = "movies")
    private Set<Genre> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<MovieImage> movieImages;

    @ManyToMany(mappedBy = "movies")
    private Set<Showtime> showtimes;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getShowingFrom() {
        return showingFrom;
    }

    public void setShowingFrom(LocalDate showingFrom) {
        this.showingFrom = showingFrom;
    }

    public LocalDate getShowingTo() {
        return showingTo;
    }

    public void setShowingTo(LocalDate showingTo) {
        this.showingTo = showingTo;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public void setShowtimes(Set<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<MovieImage> getMovieImages() {
        return movieImages;
    }

    public void setMovieImages(List<MovieImage> movieImages) {
        this.movieImages = movieImages;
    }

    public Set<Showtime> getShowtimes() {
        return showtimes;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
