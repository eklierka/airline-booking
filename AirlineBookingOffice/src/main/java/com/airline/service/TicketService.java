package com.airline.service;

import java.util.Date;
import java.util.List;

import com.airline.entity.TicketsTotal;
import com.airline.entity.TicketsTotalByDate;
import com.airline.entity.TicketsTotalByPlace;

public interface TicketService {

	// return total data (tickets count and total sum) about sold tickets during
	// a given time period
	public TicketsTotal selectTotalSumCount(Date firstDate, Date lastDate);

	// return total data about sold tickets detailed by every date during the
	// specified period of time
	public List<TicketsTotalByDate> selectTotalByDate(Date firstDate,
			Date lastDate);

	// return total data about sold tickets detailed by destination places
	// during
	// the specified period of time
	public List<TicketsTotalByPlace> selectTotalByPlace(Date firstDate,
			Date lastDate);
	
	
}
