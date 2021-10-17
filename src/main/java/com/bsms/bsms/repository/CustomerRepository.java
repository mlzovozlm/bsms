package com.bsms.bsms.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bsms.bsms.model.Customer;

@Repository
public class CustomerRepository {
	@PersistenceContext
	private EntityManager em;

	public void addCustomer(Customer customer) {

	}
}