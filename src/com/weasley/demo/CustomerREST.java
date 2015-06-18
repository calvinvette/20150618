package com.weasley.demo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/customers")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class CustomerREST {
	private CustomerDAO_JPA dao = new CustomerDAO_JPA();
	
	private CustomerDAO_JPA getDao() {
		return dao;
	}
	public void setDao(CustomerDAO_JPA dao) {
		this.dao = dao;
	}
	public void insert(Customer c) {
		dao.insert(c);
	}
	public void update(Customer c) {
		dao.update(c);
	}
	public void delete(Customer c) {
		dao.delete(c);
	}
	
	@GET
	@Path("/{id: \\d+}")
	public Customer findById(@PathParam("id") Long customerId) {
		return dao.findById(customerId);
	}
	
	@GET
	public List<Customer> findAll() {
		return dao.findAll();
	}
	
	@GET
	@Path("/lastName/{lastName}")
	public List<Customer> findByLastName(@PathParam("lastName") String lastName) {
		return dao.findByLastName(lastName);
	}
	
	@GET
	@Path("/phoneNumber/{phoneNumber}")
	public List<Customer> findByPhoneNumber(@PathParam("phoneNumber") String phoneNumber) {
		return dao.findByPhoneNumber(phoneNumber);
	}
	

}
