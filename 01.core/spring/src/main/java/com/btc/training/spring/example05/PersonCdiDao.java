package com.btc.training.spring.example05;


import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PersonCdiDao {
	

	@Inject
	private JdbcCdiConnection jdbcConnection;

	public JdbcCdiConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(JdbcCdiConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
			
}
