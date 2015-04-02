package com.airline.dao;

import java.util.List;

import com.airline.entity.Role;


public interface RoleDAO {

	public List<Role> selectAll();
	
	public void add(Role airport);
	
	public void delete(int id);

	public boolean hasWorkers(int i);

	public boolean roleExist(String role);
	
}
