package com.akatkar.spring.db.spring.repo;

import com.akatkar.spring.db.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ali Katkar
 */
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
