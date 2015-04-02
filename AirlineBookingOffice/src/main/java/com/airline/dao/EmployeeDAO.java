package com.airline.dao;

import java.util.List;

import com.airline.entity.Employee;

public interface EmployeeDAO {

	public void add(Employee emp);
	
	public Employee check(String login, String password);
	
	public Employee selectById(int id);
	
	//check existing the specified login in database
	public boolean isLoginAvailable(String login);
	
	//check existing the specified email in database
	public boolean isMailAvailable(String mail);

	public List<Employee> selectAll();
	
}
