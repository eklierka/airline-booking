package com.airline.daotests;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.airline.dao.EmployeeDAO;
import com.airline.dao.EmployeeDAOImpl;
import com.airline.entity.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDAOTest {

	static EmployeeDAO employee = new EmployeeDAOImpl();

	@Ignore
	@Test
	public void employee1Add() {
		Employee emp = new Employee();
		emp.setEmail("ksjdlfj@jsdflj.com");
		emp.setEnabled(true);
		emp.setLogin("nast");
		emp.setName("Nastia");
		emp.setPassword("1234");
		emp.setPhoneNumb("+380936178923");
		emp.setSurname("Savchyn");
		employee.add(emp);
		assertEquals("+380936178923", employee.selectById(emp.getId())
				.getPhoneNumb());
	}

	@Test
	public void employee2Check() {
		assertNotNull(employee.check("eklierka", "kt03hf01"));
	}

	@Test
	public void employee3SelectById() {
		assertEquals("eklierka", employee.selectById(1).getLogin());
	}

	@Test
	public void employee4IsLoginAvalaible() {
		assertEquals(false, employee.isLoginAvailable("eklierka"));
		assertEquals(true, employee.isLoginAvailable("blabla"));
	}

	@Test
	public void employee5IsMailAvailable() {
		assertEquals(false, employee.isMailAvailable("vkekler@gmail.com"));
		assertEquals(true, employee.isMailAvailable("vkekler@mail.ru"));
	}
}
