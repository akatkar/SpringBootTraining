package com.btc.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.btc.training.spring.example01.BinarySearchImpl;
import com.btc.training.spring.example02.PersonDao;

@SpringBootApplication
public class Example02ScopeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Example02ScopeApplication.class, args);
		
		PersonDao personDao = ctx.getBean(PersonDao.class);
		System.out.println(personDao);
		System.out.println(personDao.getJdbcConnection());
		
		PersonDao personDao2 = ctx.getBean(PersonDao.class);
		System.out.println(personDao2);
		System.out.println(personDao2.getJdbcConnection());
		System.out.println(personDao2.getJdbcConnection());
		
	}
}
