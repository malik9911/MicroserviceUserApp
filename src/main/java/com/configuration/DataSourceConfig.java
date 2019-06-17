package com.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration 
@Component
public class DataSourceConfig {
	
	@Autowired
    EnvConfigurationImp  envConfiguration;
	
	
//	@Bean
//	public DataSource getDataSource() { 
//	    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
//	    dataSourceBuilder.username(envConfiguration.getDataBaseUserName()); 
//	    dataSourceBuilder.password(envConfiguration.getDataBasePassword());
//	    dataSourceBuilder.driverClassName(envConfiguration.getDataBaseDriverName());
//	    dataSourceBuilder.url(envConfiguration.getDataBaseUrl());
//	    
//	    return dataSourceBuilder.build(); 
//	}
	
	
	@Bean 
	public DataSource getDataSource() {
	
		DriverManagerDataSource dataSource=  new  DriverManagerDataSource();
		 dataSource.setDriverClassName(envConfiguration.getDataBaseDriverName());
		 dataSource.setPassword(envConfiguration.getDataBasePassword());
		 dataSource.setUsername(envConfiguration.getDataBaseUserName());
		 dataSource.setUrl(envConfiguration.getDataBaseUrl());
		
		return dataSource;
		
		
	}
	
	
	
	
}
