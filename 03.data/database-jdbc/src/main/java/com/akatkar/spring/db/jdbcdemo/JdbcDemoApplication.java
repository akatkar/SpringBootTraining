package com.akatkar.spring.db.jdbcdemo;

import com.akatkar.spring.db.jdbcdemo.entity.Person;
import com.akatkar.spring.db.jdbcdemo.dao.PersonDao;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
        
    @Autowired
    private PersonDao personDao;
            
    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("--> all list {}",personDao.findAll());
        logger.info("--> 1002 {} ",personDao.findById(1002));
        Person p = new Person(1005, "new person","buradan", new Date());
        personDao.insert(p);
        logger.info("--> all list {}",personDao.findAll());
        p.setLocation("oradan");
        personDao.update(p);
        logger.info("--> all list {}",personDao.findAll());
        personDao.deleteById(p.getId());
        logger.info("--> all list {}",personDao.findAll()); 
    }
}
