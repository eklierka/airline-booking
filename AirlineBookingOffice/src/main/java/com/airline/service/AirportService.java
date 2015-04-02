package com.airline.service;

import java.util.List;

import com.airline.entity.Airport;

public interface AirportService {

	public void add(Airport a);
	public List<Airport> selectAll();
	public Airport find(String city, String name, String country);
	public void delete(int i);
	public boolean isDeletable(String id);
}
