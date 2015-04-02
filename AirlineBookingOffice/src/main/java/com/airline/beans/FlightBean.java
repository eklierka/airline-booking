package com.airline.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Flight;
import com.airline.service.FlightService;

@Named
@Scope("session")
public class FlightBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Flight flight;
	private Date departTime;
	private Date destTime;
	private int id;

	@Inject
	private FlightService flightService;

	public FlightBean() {
		flight = new Flight();
	}

	public String save() {
		setDates();
		flightService.save(flight);
		flight = null;
		return "adminFlights";
	}

	public String edit(String id) {
		this.id = Integer.valueOf(id);
		flight = flightService.findFlightById(this.id);
		departTime = new Date(flight.getDepartTime().getTime());
		destTime = new Date(flight.getDestTime().getTime());
		return "newFlight";
	}

	private void setDates() {
		flight.setDepartTime(new Timestamp(departTime.getTime()));
		flight.setDestTime(new Timestamp(destTime.getTime()));
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}

	public Date getDestTime() {
		return destTime;
	}

	public void setDestTime(Date destTime) {
		this.destTime = destTime;
	}

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}
}
