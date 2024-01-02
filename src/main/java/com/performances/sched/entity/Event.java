package com.performances.sched.entity;

import java.sql.Date;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @Column(name = "Restaurant_Name")
    private String RestaurantName;

    @Column(name = "Restaurant_Location")
    private String Address;

    @Column(name = "Artist_Name")
    private String ArtistName;

    @Column(name = "Date")
    private Date Date;

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    @Column(name = "Start_Time")
    private LocalTime StartingTime;

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.RestaurantName = restaurantName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        this.ArtistName = artistName;
    }

    public LocalTime getStartingTime() {
        return StartingTime;
    }

    public void setStartingTime(LocalTime startingtime) {
        this.StartingTime = startingtime;
    }
    
}
