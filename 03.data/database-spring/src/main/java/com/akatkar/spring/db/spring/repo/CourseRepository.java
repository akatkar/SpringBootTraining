package com.akatkar.spring.db.spring.repo;

import com.akatkar.spring.db.spring.model.Course;
import com.akatkar.spring.db.spring.model.Teacher;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ali Katkar
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTeacher(Teacher teacher);
}
