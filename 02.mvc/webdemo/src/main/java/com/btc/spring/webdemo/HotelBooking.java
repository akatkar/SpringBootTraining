package com.btc.spring.webdemo;


public class HotelBooking {
    
	private String hotelName;
    private Double pricePerNight;
    private int nbOfNights;
    
    
    public HotelBooking() {
    	
    }
    
	public HotelBooking(String hotelName, double pricePerNight, int nbOfNights) {
		super();
		this.hotelName = hotelName;
		this.pricePerNight = pricePerNight;
		this.nbOfNights = nbOfNights;
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
