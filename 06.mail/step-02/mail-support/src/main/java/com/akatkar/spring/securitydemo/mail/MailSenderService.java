package com.akatkar.spring.securitydemo.mail;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import com.akatkar.spring.securitydemo.model.User;
import com.akatkar.spring.securitydemo.repo.BookingRepository;
import com.akatkar.spring.securitydemo.service.UserService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author alikatkar
 */
@Service
public class MailSenderService implements MailSender {

    private static final Logger LOGGER = Logger.getLogger(MailSenderService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailContentBuilder mailBuilder;

    @Autowired
    private BookingRepository bookingRepository;

    private void sendBookingMail(User user, HotelBooking booking) {

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("no-reply@booking.com");
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("New bookings");

            String content = mailBuilder.build(user, booking);
            messageHelper.setText(content, true);
        };
        mailSender.send(messagePreparator);
    }

    private void sendBookingMail(User user, List<HotelBooking> bookings) {

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("no-reply@booking.com");
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("Daily digest mail");

            String content = mailBuilder.build(user, bookings);
            messageHelper.setText(content, true);
        };
        mailSender.send(messagePreparator);
    }

    @Scheduled(cron = "0 47 * * * *")
//    @Scheduled(cron = "00 00 01 * * *")
    private void sendDailyMail() {
        System.out.println("-------------- mail sender ------------");
        User user = userService.findByUsername("veli");
        sendBookingMail(user, bookingRepository.findAll());
    }

    @Override
    public void sendMail(HotelBooking booking) {
        User user = userService.findByUsername("ali");
        sendBookingMail(user, booking);
    }
}
