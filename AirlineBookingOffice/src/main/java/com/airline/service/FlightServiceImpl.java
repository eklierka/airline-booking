package com.airline.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.airline.dao.FlightDAO;
import com.airline.entity.Flight;
@Named
public class FlightServiceImpl implements FlightService,  Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject 
	private FlightDAO dao;
	
	@Override
	public List<Flight> searchFlight(String depart, String dest, Date date) {
		return dao.find(depart, dest, new java.sql.Date(date.getTime()));
	}

	@Override
	public Flight findFlightById(int id) {
		int i = Integer.valueOf(id);
		return dao.selectById(i);
	}
	
//	@Transactional
//	@Override
//	public void add(Flight flight) {
//		dao.add(flight);
//	}

//	@Transactional
//	@Override
//	public void update(Flight flight) {
//		dao.update(flight);
//	}

	@Override
	public List<Flight> findAllFlights() {
		return dao.selectAll();
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public List<Flight> searchSimilarFlight(String depart, String dest,
			Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -7);
		java.sql.Date first = new java.sql.Date(cal.getTime().getTime());
		java.sql.Date temp = new java.sql.Date(System.currentTimeMillis());
		if (first.compareTo(temp) < 0) {
			first = temp;
		}
		cal.add(Calendar.DATE, 14);
		java.sql.Date last = new java.sql.Date(cal.getTime().getTime());
		return dao.findSimilar(depart, dest, first, last);
	}
	
	@Override
	public boolean isDeletable(String id) {
		int i = Integer.parseInt(id);
		return dao.hasTickets(i);
	}

	@Transactional
	@Override
	public void save(Flight flight) {
		dao.save(flight);
	}

}
