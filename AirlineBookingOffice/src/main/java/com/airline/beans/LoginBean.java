package com.airline.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Employee;
import com.airline.service.EmployeeService;

@Named
@Scope("session")
public class LoginBean {

	@Inject
	private EmployeeService empService;
	private Employee emp;
	private String login;
	private String password;

	public String login() {
		emp = empService.check(login, password);
		if (emp != null) {
			String role = emp.getRole().getRole();
			if (role.equalsIgnoreCase("admin")) {
				return "adminAirports";
			} else if (role.equalsIgnoreCase("analyst")) {
				return "reportChoosingDate";
			} else if (role.equalsIgnoreCase("security")) {
				return "securityWorkers";
			} else if (role.equalsIgnoreCase("accountant")) {
				return "accountant";
			} else {
				FacesContext.getCurrentInstance().addMessage(
						"growl",
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Неправильно введений логін або пароль", null));
			}
		}
		return "login";
	}

	public String logout() {
		emp = null;
		login = null;
		return "login";
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
