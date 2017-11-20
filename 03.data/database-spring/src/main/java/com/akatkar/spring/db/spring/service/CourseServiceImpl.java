package com.akatkar.spring.db.spring.service;

import com.akatkar.spring.db.spring.model.Course;
import com.akatkar.spring.db.spring.model.Teacher;
import com.akatkar.spring.db.spring.repo.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ali Katkar
 */
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findByTeacher(Teacher teacher) {
        return courseRepository.findByTeacher(teacher);
    }
}
