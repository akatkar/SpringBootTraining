package com.btc.training.spring.example06;

public class XmlPersonDao {
	
	
	private XmlJdbcConnection xmlJdbcConnection;

	public XmlJdbcConnection getJdbcConnection() {
		return xmlJdbcConnection;
	}

	public void setXmlJdbcConnection(XmlJdbcConnection xmlJdbcConnection) {
		this.xmlJdbcConnection = xmlJdbcConnection;
	}
			
}
