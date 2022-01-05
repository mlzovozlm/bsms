package com.bsms.bsms.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BookOrder")
public class Order {
	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;

	@Column(name = "oderDate", nullable = false)
	private Date orderDate;

	@Column(name = "status", nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "employeeId", nullable = false)
	private Employee employee;

	@Column(name = "deleted")
	private boolean deleted;

	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;

}