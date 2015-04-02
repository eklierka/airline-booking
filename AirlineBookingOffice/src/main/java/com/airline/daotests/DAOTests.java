package com.airline.daotests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.airline.dao.TicketDAO;
import com.airline.dao.TicketDAOImpl;
import com.airline.entity.TicketsTotal;
import com.airline.entity.TicketsTotalByPlace;

@Named
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DAOTests {

	@Inject
	private TicketDAO dao;
	
	@Ignore
	@Test
	public void ticketSelectTotalByPlace() {
		LocalDate localDate = LocalDate.of(2011, 11, 11);
		Date firstDate = Date.valueOf(localDate);
		localDate = LocalDate.of(2020, 11, 11);
		Date lastDate = Date.valueOf(localDate);
//		List<TicketsTotalByPlace> list = ticket.selectTotalByPlace(firstDate,
//				lastDate);
//		assertEquals(2, list.size());
//		TicketsTotalByPlace t1 = list.get(0);
//		TicketsTotalByPlace t2 = list.get(1);
//		if (t1.getCity().equals("Paris")) {
//			assertEquals(1000, t1.getSum());
//			assertEquals(2, t1.getCount());
//			assertEquals(700, t2.getSum());
//			assertEquals(1, t2.getCount());
//		} else {
//			assertEquals(700, t1.getSum());
//			assertEquals(1, t1.getCount());
//			assertEquals(1000, t2.getSum());
//			assertEquals(2, t2.getCount());
//		}
	}
	
	@Test
	public void totalDataTest() {
		LocalDate localDate = LocalDate.of(2011, 11, 11);
		Date firstDate = Date.valueOf(localDate);
		localDate = LocalDate.of(2020, 11, 11);
		Date lastDate = Date.valueOf(localDate);
		List<TicketsTotalByPlace> list = dao.selectTotalByPlace(firstDate,
				lastDate);
		assertEquals(2, list.size());
		TicketsTotalByPlace t1 = list.get(0);
		TicketsTotalByPlace t2 = list.get(1);
		TicketsTotal total = dao.selectTotalSumCount(firstDate, lastDate);
		assertEquals(1700, total.getTotalCost());
//		if (t1.getCity().equals("Paris")) {
//			assertEquals(1000, t1.getSum());
//			assertEquals(2, t1.getCount());
//			assertEquals(700, t2.getSum());
//			assertEquals(1, t2.getCount());
//		} else {
//			assertEquals(700, t1.getSum());
//			assertEquals(1, t1.getCount());
//			assertEquals(1000, t2.getSum());
//			assertEquals(2, t2.getCount());
//		}
	}

	@Test
	public void getBooked() {
		LocalDate localDate = LocalDate.of(2011, 11, 11);
		Date firstDate = Date.valueOf(localDate);
		localDate = LocalDate.of(2020, 11, 11);
		Date lastDate = Date.valueOf(localDate);
		assertNotNull(dao.selectTotalSumCount(firstDate, lastDate));
	}
}
