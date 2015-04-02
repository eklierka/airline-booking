package com.airline.daotests;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.airline.dao.AirportDAO;
import com.airline.dao.AirportDAOImpl;
import com.airline.entity.Airport;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AirportDAOTest {

	//static AirportDAO airport = new AirportDAOImpl();
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	AirportDAO airport = applicationContext.getBean(AirportDAOImpl.class);

	@Test
	public void airport1SelectAll() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		AirportDAO airport = applicationContext.getBean(AirportDAOImpl.class);
		assertEquals(4, airport.selectAll().size());
	}

	@Test
	public void airport2Add() {
		Airport a = new Airport();
		a.setCountry("Netherlands");
		a.setCity("Amsterdam");
		a.setName("Schiphol");
		airport.add(a);
		assertEquals(5, airport.selectAll().size());
	}

}
