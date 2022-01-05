package com.bsms.bsms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Book")
public class Book {
	@Id
	@Column(name = "bookId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "descriptionShort")
	private String descriptionShort;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "deleted")
	private boolean deleted;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	private List<OrderDetail> orderDetails;

}