package com.akatkar.spring.securitydemo.model;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 *
 * @author Ali Katkar
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
    
    @Override
    public String getUsername(){
        return user.getUsername();
    }
}
