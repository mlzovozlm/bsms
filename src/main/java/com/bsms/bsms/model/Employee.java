package com.bsms.bsms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//include both manager (role = manager/admin) & staff (role = staff)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee")
@Entity
public class Employee {
	@Id
	private int accountId;

	@Column(name = "salary")
	private double salary;
	@Column(name = "deleted")
	private boolean deleted;

	@MapsId
	@OneToOne
	@JoinColumn(name = "accountId")
	Account account;

	@OneToMany(mappedBy = "employee")
	private List<Order> orders;

}