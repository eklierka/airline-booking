package com.airline.dao;

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

import com.airline.entity.Airport;
import com.airline.entity.Flight;

@Repository
public class FlightDAOImpl implements FlightDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public void add(Flight flight) {
		em.persist(flight);
	}

	@Override
	public List<Flight> find(String departPlace, String destPlace,
			Date departDate) {
		List<Flight> result = null;
		TypedQuery<Flight> query = em
				.createQuery(
						"SELECT f FROM Flight f where FUNCTION('lower', f.departAirport.city)=?1 and "
								+ "FUNCTION('lower', f.destAirport.city)=?2 and function('date', f.departTime)=?3 and f.numbOfTickets>0",
						Flight.class);
		query.setParameter(1, departPlace.toLowerCase());
		query.setParameter(2, destPlace.toLowerCase());
		query.setParameter(3, departDate);
		result = query.getResultList();
		return result;
	}

	@Override
	public Flight selectById(int id) {
		Flight result = null;
		TypedQuery<Flight> query = em.createQuery(
				"SELECT f FROM Flight f WHERE f.id=" + id, Flight.class);

		result = query.getSingleResult();
		return result;
	}

	@Override
	public void update(Flight flight) {
		em.merge(flight);
	}

	@Override
	public void delete(int id) {
		Query query = em.createQuery("delete from Flight f where f.id=" + id);
		query.executeUpdate();
	}

	@Override
	public void setTicketsNumber(int id, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Flight> selectAll() {
		List<Flight> result = null;
		Timestamp date = Timestamp.valueOf(LocalDateTime.now());
		TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f where f.departTime>?1",
				Flight.class);
		query.setParameter(1, date);
		result = query.getResultList();
		return result;
	}

	@Override
	public List<Flight> findSimilar(String depart, String dest, Date firstDate,
			Date lastDate) {
		List<Flight> result = null;
		TypedQuery<Flight> query = em
				.createQuery(
						"SELECT f FROM Flight f where FUNCTION('lower', f.departAirport.city)=?1 and "
								+ "FUNCTION('lower', f.destAirport.city)=?2 and function('date', f.departTime) between ?3 and ?4 and f.numbOfTickets>0",
						Flight.class);
		query.setParameter(1, depart.toLowerCase());
		query.setParameter(2, dest.toLowerCase());
		query.setParameter(3, firstDate);
		query.setParameter(4, lastDate);
		result = query.getResultList();
		return result;
	}

	@Override
	public boolean hasTickets(int id) {
		Long result = null;
		TypedQuery<Long> query = em.createQuery(
				"SELECT count(t) FROM Ticket t where t.flight.id=?1",
				Long.class);
		query.setParameter(1, id);
		result = query.getSingleResult();
		if (result.longValue() == 0L)
			return false;
		else
			return true;
	}

	@Override
	public void save(Flight flight) {
		if (flight.getId() == 0) {
			add(flight);
		} else {
			update(flight);
		}
	}

}
