package com.model.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
<<<<<<< HEAD

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.hibernate.annotations.Type;


=======
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.hibernate.annotations.Type;
>>>>>>> 54fa62ca00214a34a99419677dcb14df49902b06
import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalTime showTime;

    @ManyToMany
    @JoinTable(name = "movie_showtime", joinColumns = @JoinColumn(name = "showtime_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private List<Screen> screens;

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "id")
    private Price price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
