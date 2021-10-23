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
import javax.persistence.criteria.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {
	@Id
	private int accountId;

	@Column(name = "deleted")
	private boolean deleted;

	@MapsId
	@OneToOne
	@JoinColumn(name = "accountId")
	Account account;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
}