package com.akatkar.spring.securitydemo.mail;

import com.akatkar.spring.securitydemo.model.HotelBooking;
import com.akatkar.spring.securitydemo.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author alikatkar
 */
@Component
public class MailContentBuilder {

    private final TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(User user, HotelBooking booking) {
        Context context = new Context();
        context.setVariable("user", user);
        context.setVariable("booking", booking);
        
        return templateEngine.process("/mail/instantMail", context);
    }

    public String build(User user, List<HotelBooking> bookings) {
        Context context = new Context();
        context.setVariable("user", user);
        context.setVariable("bookings", bookings);
        
        return templateEngine.process("/mail/dailyMail", context);
    }
}
