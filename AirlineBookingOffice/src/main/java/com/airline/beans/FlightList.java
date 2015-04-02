package com.airline.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.airline.entity.Flight;
import com.airline.service.FlightService;

@Named
@Scope("session")
public class FlightList implements Serializable {

	private static final long serialVersionUID = 1L;

	private String depart;
	private String dest;
	private Date date;
	private List<Flight> flights = null;
	@Inject
	private FlightService flightService;

	public String delete(String id) {
		int i = Integer.parseInt(id);
		flightService.delete(i);
		return "adminFlights";
	}

	public void refreshList() {
		if (depart != null && dest != null && date != null) {
			flights = flightService.searchFlight(depart, dest, date);
			if (flights.isEmpty()) {
				flights = flightService.searchSimilarFlight(depart, dest, date);
			}
			depart = dest = null;
			date = null;
		} else {
			flights = null;
		}
	}

	public boolean isDeletable(String id) {
		return flightService.isDeletable(id);
	}

	public void selectAllFlights() {
		flights = flightService.findAllFlights();
	}

	public void clean(ActionEvent ae) {
		clean();
	}
	
	public String clean() {
		depart = dest = null;
		date = null;
		return "searchFlight";
	}
	
	public Date getNow() {
		return Calendar.getInstance().getTime();
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}
