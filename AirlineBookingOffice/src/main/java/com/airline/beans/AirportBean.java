package com.airline.beans;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Airport;
import com.airline.service.AirportService;

@Named
@Scope("request")
public class AirportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Airport airport;
	private boolean isAllEditable;

	@Inject
	private AirportService service;

	public AirportBean() {
		airport = new Airport();
	}

	public String add() {
		service.add(airport);
		airport = null;
		return "adminAirports";
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public boolean isAllEditable() {
		return isAllEditable;
	}

	public void setAllEditable(boolean isAllEditable) {
		this.isAllEditable = isAllEditable;
	}

}
