package com.example.demo.db;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationManager {
	
	// @Value("${conn.user}")
	private String user = "admin";
	// @Value("${conn.password}")
	private String password = "";
	// @Value("${conn.host}")
	private String host = "localhost";
	// @Value("${conn.port}")
	private String port = "8081";
	// @Value("${conn.driver}")
	private String driver = "org.exist.xmldb.DatabaseImpl";
	// @Value("${conn.uri}")
	private String uri = "xmldb:exist://localhost:8081/exist/xmlrpc";
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	

}