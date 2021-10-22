package com.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
<<<<<<< HEAD

=======
>>>>>>> 54fa62ca00214a34a99419677dcb14df49902b06
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean vip;
    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "screen_id", referencedColumnName = "id")
    private Screen screen;

    @ManyToMany
    @JoinTable(name = "booking_seat", joinColumns = @JoinColumn(name = "seat_id"), inverseJoinColumns = @JoinColumn(name = "booking_id"))
    private Set<Booking> bookings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
