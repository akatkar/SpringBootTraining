package com.akatkar.spring.securitydemo.observer;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import com.akatkar.spring.securitydemo.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author alikatkar
 */
@Component
public class BookingEventHandler implements ApplicationListener<BookingEvent> {

    @Autowired
    private MailSender mailSender;    

    @Override
    public void onApplicationEvent(BookingEvent event) {
        System.out.println("-----------> " + Thread.currentThread().getName());
        HotelBooking booking = event.getBooking();
        mailSender.sendMail(booking);
    }
}

