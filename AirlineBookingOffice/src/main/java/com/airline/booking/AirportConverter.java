package com.airline.booking;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.airline.entity.Airport;
import com.airline.service.AirportService;

@Named
public class AirportConverter implements Converter {

	@Inject
	@Autowired
	private AirportService service;

	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		List<Airport> allAirports = service.selectAll();
		for (Airport a : allAirports) {
			String id = String.valueOf(a.getId());
			if (id.equals(value)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object value) {
		if (value instanceof Airport) {
			Airport a = (Airport) value;
			return String.valueOf(a.getId());
		}
		return null;
	}
}
