package com.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private LocalDate promotionFrom;
    private LocalDate promotionTo;
    private String imageUrl;
    private double discount;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private List<Booking> bookings;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPromotionFrom() {
        return promotionFrom;
    }

    public void setPromotionFrom(LocalDate promotionFrom) {
        this.promotionFrom = promotionFrom;
    }

    public LocalDate getPromotionTo() {
        return promotionTo;
    }

    public void setPromotionTo(LocalDate promotionTo) {
        this.promotionTo = promotionTo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
