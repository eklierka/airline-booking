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
public class StatisticsServiceImpl implements StatisticsService {

	@Inject
	private TicketDAO dao;

	@Override
	public TicketsTotal selectTotal(Date from, Date to) {
		return dao.selectTotalSumCount(new java.sql.Date(from.getTime()),
				new java.sql.Date(to.getTime()));
	}

	@Override
	public List<TicketsTotalByPlace> selecTotalByPlace(Date from, Date to) {
		return dao.selectTotalByPlace(new java.sql.Date(from.getTime()),
				new java.sql.Date(to.getTime()));
	}

	@Override
	public List<TicketsTotalByDate> selectTotalByDate(Date from, Date to) {
		return dao.selectTotalByDate(new java.sql.Date(from.getTime()),
				new java.sql.Date(to.getTime()));
	}

}
