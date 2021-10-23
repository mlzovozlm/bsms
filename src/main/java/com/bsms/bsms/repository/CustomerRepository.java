package com.bsms.bsms.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bsms.bsms.model.Customer;

@Repository
@Transactional
public class CustomerRepository {
	@PersistenceContext
	private EntityManager em;

	public void addCustomer(Customer customer) {

	}
}