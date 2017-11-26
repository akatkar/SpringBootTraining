package com.akatkar.spring.securitydemo.data;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import com.akatkar.spring.securitydemo.repo.BookingRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ali Katkar
 */
@Component
public class DataProvider implements CommandLineRunner{

    @Autowired
    private BookingRepository bookingRepository;
    
    private final String[] hotels = {
        "Marriot",
        "Paris Hilton",
        "Dedeman",
        "Robinson",
        "Sheraton"       
    };
    
    private final double[] prices = {
        100.0,200.0,300.0,400.0,500.0
    };
    
    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> list = new ArrayList<>();
        
        for (int i = 0; i < hotels.length; i++) {
            list.add(new HotelBooking(i, hotels[i], prices[i], 1));
        }
        
        bookingRepository.setBookings(list);
    } 
}
