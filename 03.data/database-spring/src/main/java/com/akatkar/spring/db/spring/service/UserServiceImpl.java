package com.akatkar.spring.db.spring.service;

import com.akatkar.spring.db.spring.model.Course;
import com.akatkar.spring.db.spring.model.User;
import com.akatkar.spring.db.spring.repo.CourseRepository;
import com.akatkar.spring.db.spring.repo.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ali Katkar
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public User getUserByLoginName(String loginName) {
        return userRepository.findByUsername(loginName);
    }

    @Override
    public void enroll(User user, Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        if (user.getCourses() != null) {
            Optional<Course> courses = user.getCourses().stream()
                    .filter(c -> c.equals(course)).findFirst();

            if (!courses.isPresent()) {
                user.getCourses().add(course);
            }
        } else {
            List<Course> courses = new ArrayList<>();
            courses.add(course);
            user.setCourses(courses);
        }
        if(course.getStudents()!= null){
            Optional<User> students = course.getStudents().stream()
                    .filter(u -> u.equals(user)).findFirst();

            if (!students.isPresent()) {
                course.getStudents().add(user);
            }            
        }else{
            List<User> students = new ArrayList<>();
            students.add(user);
            course.setStudents(students);            
        }
//        courseRepository.save(course);
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getUserList(Pageable pageRequest) {
        return userRepository.findAll(pageRequest);
    }
}
