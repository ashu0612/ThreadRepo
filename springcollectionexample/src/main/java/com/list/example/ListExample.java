package com.list.example;

import java.util.List;

//injecting list using setter injection
public class ListExample {

    private List<String> list;
    public void setList(List<String> list) {
    	this.list = list;
    }
    public void printList() {
    	System.out.println(list);
    }
}
