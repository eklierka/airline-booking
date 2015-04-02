package com.airline.dao;

import java.sql.Date;
import java.util.List;

import com.airline.entity.BookedTicket;
import com.airline.entity.Flight;
import com.airline.entity.Ticket;
import com.airline.entity.TicketsTotal;
import com.airline.entity.TicketsTotalByDate;
import com.airline.entity.TicketsTotalByPlace;


public interface TicketDAO {

	public void add(Ticket t);
	
	// returns list of booked and sold tickets (for accountant)
	public List<BookedTicket> getBookedTickets();

	// set sold status to ticket defined by id
	public void setSoldStatus(int id);

	// set free status to tickets that were booked more than 3 days ago
	public int setFreeStatus();

	// return list of booked and sold tickets to the given flight
	public List<Ticket> selectByFlightId(int id);

	// return total data (tickets count and total sum) about sold tickets during
	// a given time period
	public TicketsTotal selectTotalSumCount(Date firstDate, Date lastDate);

	// return total data about sold tickets detailed by every date during the
	// specified period of time
	public List<TicketsTotalByDate> selectTotalByDate(Date firstDate, Date lastDate);

	// return total data about sold tickets detailed by destination places during
	// the specified period of time
	public List<TicketsTotalByPlace> selectTotalByPlace(Date firstDate, Date lastDate);

}
