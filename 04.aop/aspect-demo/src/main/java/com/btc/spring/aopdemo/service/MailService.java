package com.btc.spring.aopdemo.service;

import com.btc.spring.aopdemo.repository.CustomerRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ali Katkar
 */
@Service
public class MailService {
 
    @Autowired
    private CustomerRepository customerRepository;
    
    public void sendMail(){
        
        try {
            String cust = customerRepository.getCustomer();
        } catch (Exception ex) {
//            Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
