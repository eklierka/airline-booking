package com.airline.booking;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.airline.entity.Airport;

@Named
public class AirportAutoComplete {

	private Airport airport;
	@Inject
	private AirportDataSource ds;
	
	public List<Airport> completeAirport(String query) {
		List<Airport> filteredAirports = new ArrayList<Airport>();
		List<Airport> allAirports = ds.getAirports();
		for (Airport a : allAirports) {
			if (a.getCity().toLowerCase().startsWith(query.toLowerCase())) {
				filteredAirports.add(a);
			}
		}
		return filteredAirports;
	}
}
