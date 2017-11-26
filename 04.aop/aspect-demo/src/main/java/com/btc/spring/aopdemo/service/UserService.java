package com.btc.spring.aopdemo.service;

import com.btc.spring.aopdemo.aspect.TimeTrack;
import com.btc.spring.aopdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ali Katkar
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
//    @TimeTrack
    public void doSomething(){
        userRepository.getUser();
    }
}
