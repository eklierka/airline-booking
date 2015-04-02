package com.airline.beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Airport;
import com.airline.service.AirportService;

@Named
@Scope("session")
public class AirportList implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private AirportService aService;
	private List<Airport> airports;
	
	public void refreshAirports() {
		airports = aService.selectAll();
	}
	
	public boolean isDeletable(String id) {
		return aService.isDeletable(id);
	}

	public String delete(String id) {
		int index = Integer.parseInt(id);
		aService.delete(index);
		return "adminAirports";
	}
	
	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}
	
}
