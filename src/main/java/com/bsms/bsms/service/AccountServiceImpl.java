package com.bsms.bsms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bsms.bsms.model.Account;
import com.bsms.bsms.model.Role;
import com.bsms.bsms.model.UserDetailsImpl;
import com.bsms.bsms.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findAccountByEmail(username);

		if (account == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		System.out.println("Found User: " + account);
		List<Role> roles = account.getRoles();

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for (Role role : roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
				grantList.add(authority);
			}
		}

		UserDetailsImpl userDetails = new UserDetailsImpl(account);
		return userDetails;
	}

	@Override
	public void addAccount(Account account) {
		String encodedPassword = encoder.encode(account.getPassword());
		account.setPassword(encodedPassword);
		accountRepository.addAccount(account);

	}

	public Account findAccountByEmail(String email) {
		return accountRepository.findAccountByEmail(email);
	}
}