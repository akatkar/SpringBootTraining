package com.akatkar.spring.db.spring.data;

import com.akatkar.spring.db.spring.model.*;
import com.akatkar.spring.db.spring.repo.CourseRepository;
import com.akatkar.spring.db.spring.repo.TeacherRepository;
import com.akatkar.spring.db.spring.repo.UserRepository;
import com.akatkar.spring.db.spring.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ali Katkar
 */
@Component
public class DataProvider implements CommandLineRunner{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserService userService;

    
    private void generateUsers(){
        String[] users = {
            "ali","ahmet","mehmet","hasan","deniz","berna","elif"
        };
        
        List<User> userList = new ArrayList<>();
        
        for (String name : users) {
            User user = new User(name, name, Role.USER);
            userList.add(user);
            userRepository.save(user);
        }
    }
    
    private void generateTeachers(){
       
        List<User> userList = userRepository.findAll();
        
        teacherRepository.save(new Teacher(userList.get(0), null));
        teacherRepository.save(new Teacher(userList.get(1), null));
    }
    
    private void generateCourses(){        
        List<Teacher> teacherList = teacherRepository.findAll();

        courseRepository.save(new Course("Introduction to Java", teacherList.get(0), new Date(),5));
        courseRepository.save(new Course("Advanced Python", teacherList.get(0), new Date(),5));
        courseRepository.save(new Course("Spring Framework", teacherList.get(0), new Date(),5));
        courseRepository.save(new Course("SAP ABAP", teacherList.get(1), new Date(),5));        
    }
    
    private void setEnrollment(Course course, int count){        
        List<User> userList = userRepository.findAll();
        
        for (int i = 2; (i-2) < count && i < userList.size(); i++) {
            course.getStudents().add(userList.get(i));                        
        }        
    }
    
    private void generateEnrollment(){        
        List<Course> courses = courseRepository.findAll();
        
        Random random = new Random();
        for (Course course : courses) {
            setEnrollment(course, random.nextInt(5));
            courseRepository.save(course);
        }
    }
    
    
    @Override
    public void run(String... args) throws Exception {
                logger.info("Test data creation started");
        generateUsers();
        generateTeachers();
        generateCourses();
        generateEnrollment();
        logger.info("Test data has been created succesfully");
        
        User newUser = new User("New User", "new user", Role.USER);
        userRepository.save(newUser);
        List<Course> courses = courseRepository.findAll();
        
        userService.enroll(newUser, courses.get(0).getId());
        
    }
    
}
