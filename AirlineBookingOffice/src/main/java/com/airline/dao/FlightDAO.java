package com.airline.dao;

import java.sql.Date;
import java.util.List;

import com.airline.entity.Flight;

public interface FlightDAO {

	public void add(Flight flight);

	public void update(Flight flight);

	public void delete(int id);

	public List<Flight> find(String departPlace, String destPlace,
			Date departDate);

	public void setTicketsNumber(int id, int amount);

	public Flight selectById(int id);

	public List<Flight> selectAll();

	List<Flight> findSimilar(String depart, String dest, Date firstDate,
			Date lastDate);

	public boolean hasTickets(int i);
	
	public void save(Flight flight);

}
