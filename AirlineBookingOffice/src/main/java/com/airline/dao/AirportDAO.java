package com.airline.dao;

import java.util.List;

import com.airline.entity.Airport;

public interface AirportDAO {

	public List<Airport> selectAll();
	
	public void add(Airport airport);

	public Airport find(String city, String name, String country);
	
	public void delete(int i);
	
	public boolean hasFlights(int id);
	
}
