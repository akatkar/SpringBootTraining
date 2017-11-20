package com.akatkar.spring.db.spring.controller.rest;

import com.akatkar.spring.db.spring.model.Course;
import com.akatkar.spring.db.spring.model.User;
import com.akatkar.spring.db.spring.service.CourseService;
import com.akatkar.spring.db.spring.service.UserService;
import java.util.Collection;
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
@RequestMapping("/rest/course")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping("/{id}/students")
    public List<User> getCourseStudents(@PathVariable Long id) {
        return courseService.findById(id).getStudents();
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }
}
