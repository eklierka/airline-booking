package com.airline.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.airline.dao.EmployeeDAO;
import com.airline.entity.Employee;

@Named
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private EmployeeDAO empDao;

	@Override
	public List<Employee> getAllEmployees() {
		return empDao.selectAll();
	}

	@Transactional
	@Override
	public void add(Employee emp) {
		empDao.add(emp);
	}
	
	@Override
	public Employee check(String login, String password) {
		return empDao.check(login, password);
	}

	@Override
	public boolean isLoginAvailable(String login) {
		return empDao.isLoginAvailable(login);
	}

	@Override
	public boolean isMailAvailable(String mail) {
		return empDao.isMailAvailable(mail);
	}	

}
