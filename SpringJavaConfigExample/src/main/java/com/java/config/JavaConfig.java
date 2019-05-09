package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean(name = "javaBean")
	public Config config() {
		return new ConfigImpl();
	}
}
