package com.airline.service;

import java.util.Date;
import java.util.List;

import com.airline.entity.Flight;

public interface FlightService {
	List<Flight> searchFlight(String depart, String dest, Date date);
	Flight findFlightById(int i);
	//void add(Flight flight);
	//void update(Flight flight);
	List<Flight> findAllFlights();
	List<Flight> searchSimilarFlight(String depart, String dest, Date date);
	boolean isDeletable(String id);
	void delete(int id);
	void save(Flight flight);
}
