package com.airline.service;

import java.util.List;

import com.airline.entity.Role;

public interface RoleService {

	List<Role> getAllRoles();
	
	void add(Role role);
	
	void delete(int id);

	boolean isDeletable(String id);

	boolean roleExist(String role);
	
}
