package com.airline.daotests;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import com.airline.dao.CustomerDAO;
import com.airline.dao.CustomerDAOImpl;
import com.airline.entity.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDAOTest {

	static CustomerDAO customer = new CustomerDAOImpl();

	@Test
	public void customer1SelectAll() {
		assertEquals(2, customer.selectAll().size());
	}

	@Test
	public void customer2Add() {
		Customer c = new Customer();
		c.setName("Anastasia");
		c.setSurname("Savchyn");
		c.setEmail("savch@gmail.com");
		c.setPhoneNumb("+380936074958");
		c.setBookingDate(Timestamp.valueOf(LocalDateTime.of(2015, 02, 22, 16,
				25)));
		customer.add(c);
		assertEquals(3, customer.selectAll().size());
	}
}
