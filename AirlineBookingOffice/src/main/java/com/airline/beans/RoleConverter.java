package com.airline.beans;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.airline.entity.Role;

@Named
public class RoleConverter implements Converter {

	@Inject
	private RoleDataSource ds;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		List<Role> allRoles = ds.getRoles();
		for (Role r : allRoles) {
			String id = String.valueOf(r.getId());
			if (id.equals(value)) {
				return r;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object value) {
		if (value instanceof Role) {
			Role a = (Role) value;
			return String.valueOf(a.getId());
		}
		return null;
	}
}
