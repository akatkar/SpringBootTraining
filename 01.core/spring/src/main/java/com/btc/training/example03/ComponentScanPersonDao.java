package com.btc.training.example03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ComponentScanPersonDao {

	@Autowired
	private ComponentScanJdbcConnection jdbcConnection;

	public ComponentScanJdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(ComponentScanJdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
}
