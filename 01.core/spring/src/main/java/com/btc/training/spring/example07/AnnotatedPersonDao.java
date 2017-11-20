package com.btc.training.spring.example07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotatedPersonDao {
	
	@Autowired
	private AnnotatedJdbcConnection xmlJdbcConnection;

	public AnnotatedJdbcConnection getJdbcConnection() {
		return xmlJdbcConnection;
	}

	public void setXmlJdbcConnection(AnnotatedJdbcConnection xmlJdbcConnection) {
		this.xmlJdbcConnection = xmlJdbcConnection;
	}
			
}
