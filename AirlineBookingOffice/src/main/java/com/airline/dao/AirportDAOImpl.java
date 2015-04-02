package com.airline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.airline.entity.Airport;

@Repository
public class AirportDAOImpl implements AirportDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Airport> selectAll() {
		List<Airport> result = null;
		TypedQuery<Airport> query = em.createQuery("SELECT a FROM Airport a",
				Airport.class);
		result = query.getResultList();
		return result;
	}

	@Override
	public void add(Airport airport) {
		em.persist(airport);
	}

	@Override
	public Airport find(String city, String name, String country) {
		Airport result = null;
		TypedQuery<Airport> query = em
				.createQuery(
						"SELECT a FROM Airport a where a.city=?1 and a.name=?2 and a.country=?3",
						Airport.class);
		query.setParameter(1, city);
		query.setParameter(2, name);
		query.setParameter(3, country);
		result = query.getSingleResult();
		return result;
	}

	@Override
	public void delete(int i) {
		Query query = em.createQuery("delete from Airport a where a.id=" + i);
		query.executeUpdate();
	}

	@Override
	public boolean hasFlights(int id) {
		Long result = null;
		TypedQuery<Long> query = em
				.createQuery(
						"SELECT count(f) FROM Flight f where f.departAirport.id=?1 or f.destAirport.id=?1",
						Long.class);
		query.setParameter(1, id);
		result = query.getSingleResult();
		if (result.longValue() == 0L)
			return false;
		else
			return true;
	}

}
