package com.bsms.bsms.service;

import org.springframework.stereotype.Service;

import com.bsms.bsms.model.Customer;

@Service
public interface CustomerService {
	public void addCustomer(Customer customer);
}