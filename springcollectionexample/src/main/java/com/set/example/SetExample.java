package com.set.example;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



//using constructor injection
@Component
public class SetExample {
	private Set<SetMen> setexample;
	public SetExample() {
		// TODO Auto-generated constructor stub
	}
	@Autowired(required=false)
	public SetExample(Set<SetMen> setexample) {
		// TODO Auto-generated constructor stub
		this.setexample = setexample;
	}
	
	public void printSet() {
		System.out.println(setexample);
	}
}
