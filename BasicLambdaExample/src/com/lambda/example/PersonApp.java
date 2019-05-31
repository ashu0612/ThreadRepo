package com.lambda.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PersonApp /*implements SortedInterface*/ /*implements LastName*/{

	List<Person> personData = new ArrayList<>();
	public static void main(String args[]) {
		PersonApp app = new PersonApp();
		app.populateList();
		SortedInterface sortedInterface = ()->{Collections.sort(app.personData,new Person());
		return app.personData;};
		List<Person> list = sortedInterface.getSortedListByLastName();
		System.out.println(list.toString());
		
		LastName lastName=()->{List<Person> listLast = new ArrayList<>();
		for(Person p:app.personData) {
			if(p.getLastName().startsWith("m"))
			{
				listLast.add(p);
			}
		}
		return listLast;};
		System.out.println(lastName.getLastNameWithM().toString());
		List<Person> first = app.getFirstNameV(app.personData);
		System.out.println(first.toString());
		Function<Person, Boolean> function = (per)->{
			Predicate<Person> pre = (guy)->{
				if(guy.getFirstName().equals("ashu")) {
					return true;
				}
				else return false;
				
			};
			
				if (pre.test(per)) {
					return true;
				}
				else return false;
			
		}; 
		for(Person check:app.personData) {
			boolean checkAshu = function.apply(check);
			if(checkAshu) {
				System.out.println(check.toString());
			}
		}
	}
    void populateList() {
    	Person p1 = new Person("ashu", "mishra", "pune", 12345);
    	Person p2 = new Person("vishu", "mishra", "tirupati", 1234567);
    	Person p3 = new Person("vishal", "jain", "vadgao sheri", 567890);
    	personData.add(p1);
		personData.add(p2);
		personData.add(p3);
    }
  
	List<Person> getFirstNameV(List<Person> persons) {
		List<Person> listFirst = new ArrayList<>();
		Predicate<Person> person = (per)->{
			if(per.getFirstName().startsWith("v")) {
				return true;
			}
			else 
				return false;
		};
		for(Person p:persons) {
			if(person.test(p)) {
				listFirst.add(p);
			}
		}
	return listFirst;
	}
	
}
