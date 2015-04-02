package com.airline.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.airline.entity.BookedTicket;
import com.airline.entity.Flight;
import com.airline.entity.Ticket;
import com.airline.entity.TicketsTotal;
import com.airline.entity.TicketsTotalByDate;
import com.airline.entity.TicketsTotalByPlace;
@Repository
public class TicketDAOImpl implements TicketDAO, Serializable {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	EntityManager em;

	@Override
	public List<BookedTicket> getBookedTickets() {
		List<BookedTicket> result = null;
		TypedQuery<BookedTicket> query = em
				.createQuery(
						"SELECT new com.airline.entity.BookedTicket(t.id, t.flight.flightNumber, t.surname, t.name, t.document, "
								+ "t.customer.isSold, t.customer.bookingDate) FROM Ticket t",
						BookedTicket.class);
		result = query.getResultList();
		return result;
	}

	@Override
	public void setSoldStatus(int id) {
		// em = MyEntityManager.getEntityManager();
		// Ticket ticket = em.find(Ticket.class, id);
		// if (ticket != null) {
		// try {
		// em.getTransaction().begin();
		// ticket.setSold(true);
		// em.getTransaction().commit();
		// } finally {
		// em.close();
		// }
		// }
	}

	@Override
	public int setFreeStatus() {
		// em = MyEntityManager.getEntityManager();
		// LocalDateTime date = LocalDateTime.now().minusDays(3);
		// System.out.println(date);
		// Timestamp time = Timestamp.valueOf(date);
		// Query query = em
		// .createQuery("DELETE FROM Ticket t where t.customer.bookingDate<='"
		// + time + "'");
		int deleted = 0;
		// try {
		// em.getTransaction().begin();
		// deleted = query.executeUpdate();
		// em.getTransaction().commit();
		// } finally {
		// em.close();
		// }
		return deleted;
	}

	@Override
	public List<Ticket> selectByFlightId(int id) {
		List<Ticket> result = null;
		TypedQuery<Ticket> query = em.createQuery(
				"SELECT t FROM Ticket t WHERE t.flight.id="+id, Ticket.class);
		result = query.getResultList();
		return result;
	}

	@Override
	public List<TicketsTotalByDate> selectTotalByDate(Date firstDate,
			Date lastDate) {
		List<TicketsTotalByDate> result = null;
		TypedQuery<TicketsTotalByDate> query = em
				.createQuery(
						"SELECT new com.airline.entity.TicketsTotalByDate(FUNCTION('date', t.customer.bookingDate), SUM(t.price), COUNT(t.id)) "
								+ "FROM Ticket t WHERE (FUNCTION('date', t.customer.bookingDate) BETWEEN ?1 AND ?2) and t.customer.isSold>0 "
								+ "GROUP BY FUNCTION('date', t.customer.bookingDate)",
						TicketsTotalByDate.class);
		query.setParameter(1, firstDate);
		query.setParameter(2, lastDate);
		result = query.getResultList();
		return result;
	}

	@Override
	public TicketsTotal selectTotalSumCount(Date firstDate, Date lastDate) {
		TicketsTotal result = null;
		TypedQuery<TicketsTotal> query = em
				.createQuery(
						"SELECT new com.airline.entity.TicketsTotal(count(t.id), sum(t.price)) "
								+ "FROM Ticket t WHERE (FUNCTION('date', t.customer.bookingDate) BETWEEN ?1 AND ?2) and t.customer.isSold>0",
						TicketsTotal.class);
		query.setParameter(1, firstDate);
		query.setParameter(2, lastDate);
		result = query.getSingleResult();
		return result;
	}

	@Override
	public List<TicketsTotalByPlace> selectTotalByPlace(Date firstDate,
			Date lastDate) {
		List<TicketsTotalByPlace> result = null;
		TypedQuery<TicketsTotalByPlace> query = em
				.createQuery(
						"SELECT new com.airline.entity.TicketsTotalByPlace(t.flight.destAirport.country, t.flight.destAirport.city, SUM(t.price), COUNT(t.id)) "
								+ "FROM Ticket t WHERE (FUNCTION('date', t.customer.bookingDate) BETWEEN ?1 AND ?2) and t.customer.isSold>0 "
								+ "GROUP BY t.flight.destAirport.country, t.flight.destAirport.city",
						TicketsTotalByPlace.class);
		query.setParameter(1, firstDate);
		query.setParameter(2, lastDate);
		result = query.getResultList();
		return result;
	}

	@Override
	public void add(Ticket t) {
		em.persist(t);
	}

}
