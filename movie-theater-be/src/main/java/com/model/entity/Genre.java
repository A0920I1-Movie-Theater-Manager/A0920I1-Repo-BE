package com.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
<<<<<<< HEAD


=======
>>>>>>> 54fa62ca00214a34a99419677dcb14df49902b06
import javax.persistence.*;
import java.util.Set;
@Entity
@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "genre_movie", joinColumns = @JoinColumn(name = "genre_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
