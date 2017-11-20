package com.btc.spring.webdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

	
	private List<HotelBooking> bookings;
	
	public BookingRepository() {
		super();

	}
	
	
	public List<HotelBooking> getBookings() {
		return bookings;
	}


	public void setBookings(List<HotelBooking> bookings) {
		this.bookings = bookings;
	}


	public HotelBooking getHotelBooking(int index) {
		return bookings.get(index);
	}
	
	
	public List<HotelBooking> getBookingAll(){
		
		return bookings;
	}
	
	public List<HotelBooking> addHotelBooking(HotelBooking booking) {
		bookings.add(booking);
		return bookings;
	}
	
	public List<HotelBooking> deleteBooking(int index) {
		bookings.remove(index);
		return bookings;
	}	
	
}
