package com.airline.daotests;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.airline.dao.RoleDAO;
import com.airline.dao.RoleDAOImpl;
import com.airline.entity.Role;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleDAOTest {

	static RoleDAO role = new RoleDAOImpl();

	@Test
	public void role1SelectAll() {
		assertEquals(4, role.selectAll().size());
	}

	@Test
	public void role2Add() {
		Role r = new Role();
		r.setRole("customer");
		role.add(r);
		assertEquals(5, role.selectAll().size());
		roleDelete(r.getId());
	}
	
	public void roleDelete(int id) {
		role.delete(id);
		assertEquals(4, role.selectAll().size());
	}

}
