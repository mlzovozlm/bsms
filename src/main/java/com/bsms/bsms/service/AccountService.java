package com.bsms.bsms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bsms.bsms.model.Account;

public interface AccountService extends UserDetailsService {
	public abstract void addAccount(Account account);

	public abstract Account findAccountByEmail(String email);
}