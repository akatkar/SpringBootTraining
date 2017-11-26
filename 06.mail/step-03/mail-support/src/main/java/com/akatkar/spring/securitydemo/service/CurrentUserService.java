package com.akatkar.spring.securitydemo.service;

import com.akatkar.spring.securitydemo.model.CurrentUser;
import com.akatkar.spring.securitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ali Katkar
 */
@Service
public class CurrentUserService implements UserDetailsService {

    @Autowired
    private final UserService userService;

    public CurrentUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        return new CurrentUser(user);
    }
}
