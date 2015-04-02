package com.airline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.airline.entity.Employee;
import com.airline.entity.Flight;

import javax.persistence.NoResultException;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	public void add(Employee emp) {
		em.persist(emp);
	}

	@Override
	public Employee check(String login, String password) {
		Employee result = null;
		TypedQuery<Employee> query = em
				.createQuery(
						"SELECT e FROM Employee e where e.login=?1 and e.password=?2 and e.enabled>0",
						Employee.class);
		query.setParameter(1, login);
		query.setParameter(2, password);
		try {
		result = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Employee selectById(int id) {
		Employee result = null;
		TypedQuery<Employee> query = em.createQuery(
				"SELECT e FROM Employee e where e.id=" + id, Employee.class);
		result = query.getSingleResult();
		return result;
	}

	@Override
	public boolean isLoginAvailable(String login) {
		Employee result = null;
		TypedQuery<Employee> query = em.createQuery(
				"SELECT e FROM Employee e where e.login=?1", Employee.class);
		query.setParameter(1, login);
		try {
			result = query.getSingleResult();
		} catch (NoResultException e) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isMailAvailable(String mail) {
		Employee result = null;
		TypedQuery<Employee> query = em.createQuery(
				"SELECT e FROM Employee e where e.email=?1", Employee.class);

		query.setParameter(1, mail);
		try {
			result = query.getSingleResult();
		} catch (NoResultException e) {
			return true;
		}
		return false;

	}

	@Override
	public List<Employee> selectAll() {
		List<Employee> result = null;
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e",
				Employee.class);
		result = query.getResultList();
		return result;
	}

}
