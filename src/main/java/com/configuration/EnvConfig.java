package com.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","pro","stag"})
public class EnvConfig {

	
	public EnvConfiguration getEnviroment() {
		return new EnvConfigurationImp();
	}
}
