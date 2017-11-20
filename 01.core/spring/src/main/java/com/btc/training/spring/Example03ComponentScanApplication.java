package com.btc.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.btc.training.example03.ComponentScanPersonDao;
import com.btc.training.spring.example01.BinarySearchImpl;
import com.btc.training.spring.example02.PersonDao;

@SpringBootApplication
@ComponentScan({"com.btc.training.example03","com.btc.training.spring"})
public class Example03ComponentScanApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Example03ComponentScanApplication.class, args);
		
		ComponentScanPersonDao personDao = ctx.getBean(ComponentScanPersonDao.class);
		System.out.println(personDao);
		System.out.println(personDao.getJdbcConnection());
		
		PersonDao personDao2 = ctx.getBean(PersonDao.class);
		System.out.println(personDao2);
		System.out.println(personDao2.getJdbcConnection());
		System.out.println(personDao2.getJdbcConnection());
		
	}
}
