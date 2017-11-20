package com.btc.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.btc.training.example03.ComponentScanPersonDao;
import com.btc.training.spring.example01.BinarySearchImpl;
import com.btc.training.spring.example02.PersonDao;
import com.btc.training.spring.example04.PersonLifeCycleDao;
import com.btc.training.spring.example05.PersonCdiDao;

@SpringBootApplication
public class Example05CdiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Example05CdiApplication.class, args);
		
		PersonCdiDao personDao = ctx.getBean(PersonCdiDao.class);
		System.out.println(personDao);
		System.out.println(personDao.getJdbcConnection());
		
			
	}
}
