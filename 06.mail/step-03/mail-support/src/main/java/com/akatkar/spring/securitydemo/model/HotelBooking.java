package com.akatkar.spring.securitydemo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Ali Katkar
 */
@Entity
public class HotelBooking implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    private String hotelName;
    private Double pricePerNight;
    private int nbOfNights;

    public HotelBooking() {
    }

    public HotelBooking(User user, String hotelName, Double price, int nights) {
        this.user = user;
        this.hotelName = hotelName;
        this.pricePerNight = price;
        this.nbOfNights = nights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    public void setNbOfNights(int nbOfNights) {
        this.nbOfNights = nbOfNights;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "HotelBooking{" + "hotelName=" + hotelName + ", pricePerNight=" + pricePerNight + ", nbOfNights=" + nbOfNights + '}';
    }
}
