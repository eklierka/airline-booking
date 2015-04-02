package com.airline.service;

import java.util.Date;
import java.util.List;

import com.airline.entity.TicketsTotal;
import com.airline.entity.TicketsTotalByDate;
import com.airline.entity.TicketsTotalByPlace;

public interface StatisticsService {
	
	public TicketsTotal selectTotal(Date from, Date to);
	public List<TicketsTotalByPlace> selecTotalByPlace(Date from, Date to);
	public List<TicketsTotalByDate> selectTotalByDate(Date from, Date to);
}
