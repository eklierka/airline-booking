package com.airline.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.airline.dao.RoleDAO;
import com.airline.entity.Role;

@Named
public class RoleServiceImpl implements RoleService {

	@Inject
	private RoleDAO roleDao;
	
	@Override
	public List<Role> getAllRoles() {
		return roleDao.selectAll();
	}

	@Transactional
	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Transactional
	@Override
	public void delete(int id) {
		roleDao.delete(id);
	}

	@Override
	public boolean isDeletable(String id) {
		int i = Integer.parseInt(id);
		return roleDao.hasWorkers(i);
	}

	@Override
	public boolean roleExist(String role) {
		return roleDao.roleExist(role);
	}
	
	

}
