package com.btc.training.spring.example08;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="myconfig")
public class MyConfig2 {
	
	private String appName;
	private String appDescription;
	private String adminFirstName;
	private String adminLastName;
	private String adminMail;
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppDescription() {
		return appDescription;
	}
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	@Override
	public String toString() {
		return "MyConfig2 [appName=" + appName + ", appDescription=" + appDescription + ", adminFirstName="
				+ adminFirstName + ", adminLastName=" + adminLastName + ", adminMail=" + adminMail + "]";
	}
	
}
