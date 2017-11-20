package com.btc.spring.webdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingRestController {
	
	@Autowired
	private BookingRepository bookingRepository;
	 
	//@RequestMapping(value = "/get", method = RequestMethod.GET)
	@GetMapping("/get/{index}")
	public HotelBooking getBooking(@PathVariable int index){
		return bookingRepository.getHotelBooking(index);
	}
	
	@GetMapping("/all")
	public List<HotelBooking> getBookingAll(){
		
		return bookingRepository.getBookingAll();
	}
	
	
	@PostMapping("/add")
	public List<HotelBooking> getBookingAll(@RequestBody  HotelBooking booking){
		
		return bookingRepository.addHotelBooking(booking);
	}
	
	@DeleteMapping("/delete/{index}")
	public List<HotelBooking> getBookingAll(@PathVariable int index){
		
		return bookingRepository.deleteBooking(index);
	}
}
