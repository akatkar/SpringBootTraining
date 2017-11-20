package com.akatkar.spring.db.jpademo;

import com.akatkar.spring.db.jpademo.dao.PersonDao;
import com.akatkar.spring.db.jpademo.entity.Person;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonDao personDao;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("--> all list {}",personDao.findAll());
        logger.info("--> 1002 {} ",personDao.findById(1002));
        Person p = new Person("new person","buradan", new Date());
        p = personDao.insert(p);
        logger.info("--> all list {}",personDao.findAll());
        p.setLocation("oradan");
        personDao.update(p);
        logger.info("--> all list {}",personDao.findAll());
        personDao.deleteById(p.getId());
        logger.info("--> all list {}",personDao.findAll());
    }
}
