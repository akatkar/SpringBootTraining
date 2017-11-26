package com.btc.spring.aopdemo;

import com.btc.spring.aopdemo.service.MailService;
import com.btc.spring.aopdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopdemoApplication implements CommandLineRunner{

    @Autowired
    private MailService mailService;
    
    @Autowired
    private UserService userService;
    
    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        mailService.sendMail();
        userService.doSomething();
    }
}
