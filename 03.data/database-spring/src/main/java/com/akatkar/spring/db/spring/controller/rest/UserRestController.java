package com.akatkar.spring.db.spring.controller.rest;

import com.akatkar.spring.db.spring.model.User;
import com.akatkar.spring.db.spring.service.UserService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ali Katkar
 */
@RestController
@RequestMapping("/rest/user")
public class UserRestController {
    
    private static final int PAGE_SIZE = 2;
    
    @Autowired
    private UserService userService;
        
    @GetMapping("/{id}")
    public User getUserId(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/page/{page}")
    public List<User> getUserId(@PathVariable int page) {
        Page<User> userPage;

        // Find all users by page
        PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE);
        userPage = userService.getUserList(pageRequest);

        if (!userPage.hasContent()) {
            return Collections.EMPTY_LIST;
        }

        return (List) userPage.getContent();
    }   
}
