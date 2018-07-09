package com.akatkar.spring.db.spring.service;

import com.akatkar.spring.db.spring.model.Course;
import com.akatkar.spring.db.spring.model.Teacher;
import com.akatkar.spring.db.spring.model.User;
import com.akatkar.spring.db.spring.repo.CourseRepository;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Ali Katkar
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {
    
    @Mock
    private CourseRepository mockCourseRepository;
    
    @InjectMocks
    private CourseServiceImpl courseServiceImpl;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findById method, of class CourseServiceImpl.
     */
    @Test
    public void testFindById() {
        Long id = 1L;
        Course expResult = new Course("Test Course", new Teacher(), new Date(), 0);
        
        when(mockCourseRepository.findById(id))
                .thenReturn(Optional.of(expResult));
        
        Course result = courseServiceImpl.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class CourseServiceImpl.
     */
    @Test
    public void testFindAll() {
        
        List<Course> expResult = Arrays.asList(
            new Course("Test Course 2", new Teacher(), new Date(), 0),
            new Course("Test Course 1", new Teacher(), new Date(), 0)                
        );
        
        when(mockCourseRepository.findAll()).
                thenReturn(expResult);
        
        List<Course> result = courseServiceImpl.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of findByTeacher method, of class CourseServiceImpl.
     */
    @Test
    public void testFindByTeacher() {
        
        List<Course> expResult = Arrays.asList(
            new Course("Test Course 2", new Teacher(), new Date(), 0),
            new Course("Test Course 1", new Teacher(), new Date(), 0)                
        );
        Teacher teacher = new Teacher(new User(), expResult);
        
        when(mockCourseRepository.findByTeacher(teacher)).
                thenReturn(expResult);
        
        List<Course> result = courseServiceImpl.findByTeacher(teacher);
        assertEquals(expResult, result);       
    }
}
