package com.btc.spring.webdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
//@Profile("development")
public class DataProvider implements CommandLineRunner {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		List<HotelBooking> bookings = new ArrayList<>();
		bookings.add(new HotelBooking("dedeman", 100.0, 1));
		bookings.add(new HotelBooking("shreton", 200.0, 1));
		bookings.add(new HotelBooking("hilton", 300.0, 1));
		bookings.add(new HotelBooking("divan", 400.0, 1));
		bookings.add(new HotelBooking("black mont", 500.0, 1));	
		bookingRepository.setBookings(bookings);
	}

}
