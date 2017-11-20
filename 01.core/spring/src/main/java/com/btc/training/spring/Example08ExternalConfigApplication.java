package com.btc.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.btc.training.spring.example08.MyConfig2;
import com.btc.training.spring.example08.MyConfigClass;

@SpringBootApplication
public class Example08ExternalConfigApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Example07AnnotatedConfigApplication.class, args);
		
		MyConfigClass myClass = ctx.getBean(MyConfigClass.class);
		
		System.out.println(myClass.getMail());
		System.out.println(myClass.getDatabase());
			
		MyConfig2 my2 = ctx.getBean(MyConfig2.class);
		
		System.out.println(my2);
						
	}
}
