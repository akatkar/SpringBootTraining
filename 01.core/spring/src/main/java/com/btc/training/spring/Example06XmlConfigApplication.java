package com.btc.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.btc.training.example03.ComponentScanPersonDao;
import com.btc.training.spring.example01.BinarySearchImpl;
import com.btc.training.spring.example02.PersonDao;
import com.btc.training.spring.example04.PersonLifeCycleDao;
import com.btc.training.spring.example05.PersonCdiDao;
import com.btc.training.spring.example06.XmlPersonDao;

@SpringBootApplication
public class Example06XmlConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(Example06XmlConfigApplication.class, args);
		
		
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")){
			
		
			XmlPersonDao personDao = ctx.getBean(XmlPersonDao.class);
			System.out.println(personDao);
			System.out.println(personDao.getJdbcConnection());
		
		}
						
	}
}
