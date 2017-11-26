package com.akatkar.spring.securitydemo.observer;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author alikatkar
 */
@Component
public class BookingEventPublisher implements ApplicationEventPublisherAware {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Async
    public void sendPublishEvent(HotelBooking booking) {
        System.out.println("-----------> " + Thread.currentThread().getName());
        eventPublisher.publishEvent(new BookingEvent(this, booking));
    }
}
