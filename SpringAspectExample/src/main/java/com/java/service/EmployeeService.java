package com.java.service;

import com.java.EmployeeInterface.EmployeeDetails;
import com.java.model.Employee;

public class EmployeeService implements EmployeeDetails{

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void getEmployeeDetals() {
		System.out.println("employeedetails are :"+employee.getName()+" and company is :"+employee.getCompany());
	}

	public void getEmployeeName() {
		System.out.println("employee name is :"+employee.getName());
	}

	public void getCompanyName() {
		System.out.println("employee's company is :"+employee.getCompany());
	}
	
}
