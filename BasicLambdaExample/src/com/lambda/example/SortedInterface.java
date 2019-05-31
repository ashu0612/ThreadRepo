package com.lambda.example;

import java.util.List;

@FunctionalInterface
public interface SortedInterface {

	List<Person> getSortedListByLastName();
}
