package com.airline.service;

import java.util.List;

import com.airline.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	void add(Employee emp);

	public Employee check(String login, String password);

	public boolean isLoginAvailable(String login);

	public boolean isMailAvailable(String mail);
}
