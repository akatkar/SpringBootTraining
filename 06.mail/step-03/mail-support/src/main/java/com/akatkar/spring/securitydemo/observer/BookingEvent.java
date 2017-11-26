package com.akatkar.spring.securitydemo.observer;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author alikatkar
 */
public class BookingEvent extends ApplicationEvent{
    
    private final HotelBooking booking;
    
    public BookingEvent(Object source, HotelBooking booking) {
        super(source);
        this.booking = booking;
    }

    public HotelBooking getBooking() {
        return booking;
    }    
}
