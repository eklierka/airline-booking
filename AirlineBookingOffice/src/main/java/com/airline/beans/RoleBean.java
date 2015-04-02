package com.airline.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Role;
import com.airline.service.RoleService;

@Named
@Scope("request")
public class RoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Role role;

	@Inject
	private RoleService service;

	public RoleBean() {
		role = new Role();
	}

	public String add() {
		if (!roleExist()) {
			service.add(role);
			role = new Role();
			return "securityRoles";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					"growl",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Роль вже існує.", null));
			return "newRole";
		}
	}

	private boolean roleExist() {
		if (service.roleExist(role.getRole())) {
			return false;
		}
		return true;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
