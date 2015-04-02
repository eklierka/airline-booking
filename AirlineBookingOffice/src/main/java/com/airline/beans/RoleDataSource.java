package com.airline.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.airline.entity.Role;
import com.airline.service.RoleService;

@Named
public class RoleDataSource {

	@Inject
	private RoleService service;
	private List<Role> roles;

	@PostConstruct
	public void refreshRoles() {
		roles = service.getAllRoles();
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
