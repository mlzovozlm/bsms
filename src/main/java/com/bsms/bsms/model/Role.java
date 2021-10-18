package com.bsms.bsms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "Role")
public class Role {
	@Id
	@Column(name = "roleId")
	private int id;
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<Account> accounts;
}