package com.btc.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.btc.training.example03.ComponentScanPersonDao;
import com.btc.training.spring.example01.BinarySearchImpl;
import com.btc.training.spring.example02.PersonDao;
import com.btc.training.spring.example04.PersonLifeCycleDao;

@SpringBootApplication
public class Example04LifeCycleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Example04LifeCycleApplication.class, args);
		
		PersonLifeCycleDao personDao = ctx.getBean(PersonLifeCycleDao.class);
		System.out.println(personDao);
		System.out.println(personDao.getJdbcConnection());
		
		System.out.println(personDao.getCreateDate());
		

		PersonLifeCycleDao personDao2 = ctx.getBean(PersonLifeCycleDao.class);
		System.out.println(personDao2);
		System.out.println(personDao2.getJdbcConnection());
		
		System.out.println(personDao2.getCreateDate());
		
	}
}
