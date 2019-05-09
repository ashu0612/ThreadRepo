package com.set.example;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.set.example")
public class SetConfig {

	@Bean
	public SetMen setMen() {
		return new SetMen();
	}
	@Bean
	public SetExample setExample() {
		return new SetExample(new HashSet<SetMen>());
	}
	
	
}
