package com.akatkar.spring.db.spring.service;

import com.akatkar.spring.db.spring.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ali Katkar
 */
public interface UserService {

    User getUserByLoginName(String loginName);

    void enroll(User user, Long courseId);

    User findById(Long id);

    List<User> getUserList();
    
    Page<User> getUserList(Pageable pageRequest);
}
