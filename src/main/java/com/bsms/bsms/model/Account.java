package com.bsms.bsms.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//account model - for login + register only

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account")
public class Account implements UserDetails {

	private static final long serialVersionUID = -3164082858501464263L;

	@Id
	@Column(name = "accountId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "password", length = 128, nullable = false)
	private String password;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "deleted")
	private boolean deleted;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "AccountRole", joinColumns = @JoinColumn(name = "accountId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<Role> roles;

	@OneToOne(mappedBy = "account")
	private Customer customer;
	@OneToOne(mappedBy = "account")
	private Employee employee;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}