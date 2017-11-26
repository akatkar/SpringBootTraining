package com.btc.spring.aopdemo.repository;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ali Katkar
 */
@Repository
public class UserRepository {
    
    public String getUser(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
//            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "my user";
    }
}
