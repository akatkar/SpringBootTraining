package com.akatkar.spring.db.spring.service;

import com.akatkar.spring.db.spring.model.Course;
import com.akatkar.spring.db.spring.model.Teacher;
import java.util.List;

/**
 *
 * @author Ali Katkar
 */
public interface CourseService {
    
    public Course findById(Long id);
    
    public List<Course> findAll();
    
    public List<Course> findByTeacher(Teacher teacher);  
}
