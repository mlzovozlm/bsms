package com.bsms.bsms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderDetail")
public class OrderDetail {
	@Id
	@Column(name = "detailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;

	@ManyToOne
	@JoinColumn(name = "orderId", nullable = false)
	private Order order;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private Book book;

	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "deleted")
	private boolean deleted;

}