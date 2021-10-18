package com.bsms.bsms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsms.bsms.model.Customer;
import com.bsms.bsms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.addCustomer(customer);

	}

}