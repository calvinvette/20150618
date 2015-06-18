package com.weasley.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerDAO_JPA {
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void insert(Customer c) {
		getEntityManager().persist(c);
	}
	
	public void update(Customer c) {
		getEntityManager().merge(c);
	}
	
	public void delete(Customer c) {
		getEntityManager().remove(c);
	}
	
	public Customer findById(Long customerId) {
		return getEntityManager().find(Customer.class, customerId);
	}
	
	public List<Customer> findAll() {
		return getEntityManager().createNamedQuery(Customer.FIND_ALL, Customer.class).getResultList();
	}
	
	public List<Customer> findByLastName(String lastName) {
		return getEntityManager().createNamedQuery(Customer.FIND_BY_LASTNAME, Customer.class)
				.setParameter("lastName", lastName)
				.getResultList();
	}
	
	public List<Customer> findByPhoneNumber(String phoneNumber) {
		return getEntityManager().createNamedQuery(Customer.FIND_BY_PHONENUMBER, Customer.class)
		.setParameter("phoneNumber", phoneNumber)
		.getResultList();
	}
	
	
}
