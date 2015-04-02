package com.airline.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.airline.dao.AirportDAO;
import com.airline.dao.AirportDAOImpl;
import com.airline.entity.Airport;

@Named
public class AirportServiceImpl implements AirportService {

	@Inject
	private AirportDAO dao;

	@Transactional
	@Override
	public void add(Airport a) {
		dao.add(a);
	}

	@Override
	public List<Airport> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Airport find(String city, String name, String country) {
		return dao.find(city, name, country);
	}

	@Transactional
	@Override
	public void delete(int i) {
		dao.delete(i);
	}

	@Override
	public boolean isDeletable(String id) {
		int i = Integer.parseInt(id);
		return dao.hasFlights(i);
	}

}
