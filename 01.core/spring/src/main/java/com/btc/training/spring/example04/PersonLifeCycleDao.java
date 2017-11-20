package com.btc.training.spring.example04;


import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class PersonLifeCycleDao {
	
	private Date createDate;

	@Autowired
	private JdbcLifeCycleConnection jdbcConnection;

	public JdbcLifeCycleConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(JdbcLifeCycleConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
	@PostConstruct
	public void postConstruct() {
		createDate = new Date();
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Destroyed");;
	}
	

	public Date getCreateDate() {
		return createDate;
	}

		
}
