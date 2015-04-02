package com.airline.booking;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.airline.entity.Airport;
import com.airline.service.AirportService;

@Named
public class AirportDataSource {

	@Inject
	private AirportService service;
	private List<Airport> airports;

	@PostConstruct
	public void refresh() {
		airports = service.selectAll();
	}

	public AirportService getService() {
		return service;
	}

	public void setService(AirportService service) {
		this.service = service;
	}

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

}
