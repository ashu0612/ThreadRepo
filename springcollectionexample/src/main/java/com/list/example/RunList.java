/*package com.list.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunList {

	public static void main(String args[]) {
		List<String> list = Arrays.asList("ashu","vishu");
		ApplicationContext con = new AnnotationConfigApplicationContext(ListConfig.class);
		ListExample exampleList = (ListExample) con.getBean("listBean");
		exampleList.setList(list);
		exampleList.printList();
	}
}
*/