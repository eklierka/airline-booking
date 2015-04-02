package com.airline.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Employee;
import com.airline.entity.Role;
import com.airline.service.EmployeeService;

@Named
@Scope("request")
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Employee emp;

	@Inject
	private EmployeeService service;

	public EmployeeBean() {
		emp = new Employee();
	}

	public String add() {
		if (isValid()) {
			service.add(emp);
			emp = null;
			return "security";
		} else {
			return "newEmployee";
		}
	}

	private boolean isValid() {
		boolean b = true;
		if (!service.isLoginAvailable(emp.getLogin())) {
			b = false;
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Такий логін вже існує.", null));
		}
		if (!service.isMailAvailable(emp.getEmail())) {
			b = false;
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Такий e-mail вже існує.", null));
		}
		return b;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
