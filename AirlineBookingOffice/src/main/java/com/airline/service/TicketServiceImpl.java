package com.airline.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.airline.dao.TicketDAO;
import com.airline.entity.TicketsTotal;
import com.airline.entity.TicketsTotalByDate;
import com.airline.entity.TicketsTotalByPlace;

@Named
public class TicketServiceImpl implements TicketService {

	@Inject
	private TicketDAO dao;

	@Override
	public TicketsTotal selectTotalSumCount(Date firstDate, Date lastDate) {
		return dao.selectTotalSumCount(new java.sql.Date(firstDate.getTime()), new java.sql.Date(lastDate.getTime()));
	}

	@Override
	public List<TicketsTotalByDate> selectTotalByDate(Date firstDate,
			Date lastDate) {
		return dao.selectTotalByDate(new java.sql.Date(firstDate.getTime()), new java.sql.Date(lastDate.getTime()));
	}

	@Override
	public List<TicketsTotalByPlace> selectTotalByPlace(Date firstDate,
			Date lastDate) {
		return dao.selectTotalByPlace(new java.sql.Date(firstDate.getTime()), new java.sql.Date(lastDate.getTime()));
	}

}
