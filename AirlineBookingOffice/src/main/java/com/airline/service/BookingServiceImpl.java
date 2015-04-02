package com.airline.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.airline.dao.CustomerDAO;
import com.airline.dao.CustomerDAOImpl;
import com.airline.dao.FlightDAO;
import com.airline.dao.TicketDAO;
import com.airline.dao.TicketDAOImpl;
import com.airline.entity.Customer;
import com.airline.entity.Flight;
import com.airline.entity.Ticket;

@Named
public class BookingServiceImpl implements BookingService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private TicketDAO tickDao;
	@Inject
	private CustomerDAO custDao;
	@Inject
	private FlightDAO flightDao;
	
	@Override
	@Transactional
	public void book(Customer customer, List<Ticket> tickets) {
		customer.setSold(false);
		customer.setBookingDate(Timestamp.valueOf(LocalDateTime.now()));
		custDao.add(customer);				
		Iterator<Ticket> t = tickets.iterator();
		while (t.hasNext()) {
			Ticket ticket = t.next();
			ticket.setCustomer(customer);
			tickDao.add(ticket);
			Flight f = ticket.getFlight();
			int numb = f.getNumbOfTickets();
			f.setNumbOfTickets(numb-1);
			flightDao.update(f);
		}
	}
}
