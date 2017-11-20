package com.btc.training.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.btc.training.spring.example07.AnnotatedPersonDao;

@SpringBootApplication
public class Example07AnnotatedConfigApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(Example07AnnotatedConfigApplication.class, args);
		
		
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Example07AnnotatedConfigApplication.class)){
			
		
			AnnotatedPersonDao personDao = ctx.getBean(AnnotatedPersonDao.class);
			System.out.println(personDao);
			System.out.println(personDao.getJdbcConnection());
		
		}
						
	}
}
