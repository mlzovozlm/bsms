package com.bsms.bsms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bsms.bsms.model.Customer;
import com.bsms.bsms.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.addCustomer(customer);

	}

}