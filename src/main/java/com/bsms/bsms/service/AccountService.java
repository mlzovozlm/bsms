package com.bsms.bsms.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.bsms.bsms.model.Account;

@Service
public interface AccountService extends UserDetailsService {
	public void addAccount(Account account);

	public Account findAccountByEmail(String email);
}