package com.akatkar.spring.securitydemo.mail;

import com.akatkar.spring.securitydemo.model.HotelBooking;

/**
 *
 * @author alikatkar
 */
@FunctionalInterface
public interface MailSender {

    public void sendMail(HotelBooking booking);
}
