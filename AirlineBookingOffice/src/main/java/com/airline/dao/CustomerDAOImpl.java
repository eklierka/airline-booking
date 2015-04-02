package com.airline.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.airline.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Customer> selectAll() {
		List<Customer> result = null;
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c",
				Customer.class);
		result = query.getResultList();
		return result;
	}

	@Override
	public void add(Customer customer) {
		em.persist(customer);
	}

}
