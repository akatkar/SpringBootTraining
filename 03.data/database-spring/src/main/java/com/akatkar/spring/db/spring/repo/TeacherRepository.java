package com.akatkar.spring.db.spring.repo;

import com.akatkar.spring.db.spring.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ali Katkar
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
