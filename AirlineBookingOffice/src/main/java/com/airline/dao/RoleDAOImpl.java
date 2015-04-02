package com.airline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.airline.entity.Employee;
import com.airline.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Role> selectAll() {
		List<Role> result = null;
		TypedQuery<Role> query = em.createQuery("SELECT r FROM Role r",
				Role.class);
		result = query.getResultList();
		return result;
	}

	@Override
	public void add(Role role) {
		em.persist(role);
	}

	@Override
	public void delete(int id) {
		Query query = em.createQuery("delete from Role r where r.id=" + id);
		query.executeUpdate();
	}

	@Override
	public boolean hasWorkers(int id) {
		Long result = null;
		TypedQuery<Long> query = em.createQuery(
				"SELECT count(e.role.id) FROM Employee e where e.role.id=?1",
				Long.class);
		query.setParameter(1, id);
		result = query.getSingleResult();
		if (result.longValue() == 0L) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean roleExist(String role) {
		Long result = null;
		TypedQuery<Long> query = em.createQuery(
				"SELECT count(r.role) FROM Role r where r.role=?1", Long.class);
		query.setParameter(1, role);
		result = query.getSingleResult();
		if (result.longValue() == 0L)
			return true;
		else
			return false;
	}
}
