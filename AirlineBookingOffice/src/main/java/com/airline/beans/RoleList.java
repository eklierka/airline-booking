package com.airline.beans;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Airport;
import com.airline.entity.Role;
import com.airline.service.RoleService;

@Named
@Scope("session")
public class RoleList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RoleService roleService;

	private List<Role> roles;

	public void refreshRoles() {
		roles = roleService.getAllRoles();
	}

	public boolean isDeletable(String id) {
		return roleService.isDeletable(id);
	}

	public String delete(String id) {
		int index = Integer.parseInt(id);
		roleService.delete(index);
		return "securityRoles";
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
