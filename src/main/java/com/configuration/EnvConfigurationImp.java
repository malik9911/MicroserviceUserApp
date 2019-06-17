package com.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EnvConfigurationImp implements EnvConfiguration {

	@Value("${spring.database.ip}")
	private String dbIp;
	
	@Value("${spring.datasource.url}")
    private String datasourceUrl;
	
	@Value("${spring.datasource.password}")
	private String dbPasssowrd;
	
	@Value("${spring.datasource.username}")
	private String dbUserName ;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	
	@Value ("${server.port}")
	private String serverPort;
	
	@Override
	public String getDataBaseUrl() {
		// TODO Auto-generated method stub
		return datasourceUrl;
	}

	@Override
	public String getDataBaseUserName() {
		// TODO Auto-generated method stub
		return dbUserName;
	}

	@Override
	public String getDataBasePassword() {
		// TODO Auto-generated method stub
		return dbPasssowrd;
	}

	@Override
	public String getDataBasePort() {
		// TODO Auto-generated method stub
		return serverPort;
	}

	@Override
	public String getDataBaseIp() {
		// TODO Auto-generated method stub
		return dbIp;
	}

	@Override
	public String getDataBaseDriverName() {
		// TODO Auto-generated method stub
		return driverClassName;
	}

	
	
	
	
	
}
