package com.airline.beans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Employee;
import com.airline.service.EmployeeService;

@Named
@Scope("session")
public class EmployeeList {

	@Inject
	private EmployeeService empService;
	private List<Employee> employees;

	public void refreshEmployees() {
		employees = empService.getAllEmployees();
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
