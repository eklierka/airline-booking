package com.airline.dao;

import java.util.List;

import com.airline.entity.Customer;

public interface CustomerDAO {

	public List<Customer> selectAll();
	
	public void add(Customer customer);
}
