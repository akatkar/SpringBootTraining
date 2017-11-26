package com.akatkar.spring.securitydemo.model;

/**
 *
 * @author Ali Katkar
 */
public class HotelBooking {

    private int id;
    private String hotelName;
    private Double pricePerNight;
    private int nbOfNights;

    public HotelBooking() {
    }

    public HotelBooking(int id, String hotelName, Double price, int nights) {
        this.id = id;
        this.hotelName = hotelName;
        this.pricePerNight = price;
        this.nbOfNights = nights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
