package com.akatkar.spring.securitydemo.repo;

import com.akatkar.spring.securitydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ali Katkar
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
