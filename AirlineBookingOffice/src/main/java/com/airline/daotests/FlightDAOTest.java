package com.airline.daotests;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Ignore;
import org.junit.Test;

import com.airline.dao.FlightDAO;
import com.airline.dao.FlightDAOImpl;
import com.airline.entity.Airport;
import com.airline.entity.Flight;

public class FlightDAOTest {

	static FlightDAO flight = new FlightDAOImpl();

	public static Airport getAirport(int id) {
//		EntityManager em = MyEntityManager.getEntityManager();
//		TypedQuery<Airport> query = em.createQuery(
//				"select a from Airport a where a.id=" + id, Airport.class);
		Airport result = null;
//		try {
//			result = query.getSingleResult();
//		} finally {
//			em.close();
//		}
		return result;
	}

	@Ignore
	@Test
	public void flight1Add() {
		Flight f = new Flight();
		f.setDepartAirport(getAirport(1));
		f.setDestAirport(getAirport(3));
		f.setFlightNumber("DJK9348");
		flight.add(f);
		assertEquals("DJK9348", flight.selectById(f.getId()).getFlightNumber());
	}

	@Ignore
	@Test
	public void flight2Update() {
		Flight f = flight.selectById(2);
		f.setFlightNumber("LN123");
		flight.update(f);
		assertEquals("LN123", flight.selectById(2).getFlightNumber());
	}

	@Test
	public void flight3Find() {
		LocalDate d = LocalDate.of(2011, 11, 11);
		Date date = Date.valueOf(d);
		assertNotEquals(null, flight.find("london", "paris", date));
	}
}
