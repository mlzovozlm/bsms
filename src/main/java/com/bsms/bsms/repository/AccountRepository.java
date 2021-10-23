package com.bsms.bsms.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bsms.bsms.model.Account;

@Repository
@Transactional
public class AccountRepository {
	@PersistenceContext
	private EntityManager em;

	public Account findAccountByEmail(String email) {
		try {
			String sql = "SELECT a from Account a "
					+ " WHERE a.email = :email";
			Query query = em.createQuery(sql, Account.class);
			query.setParameter("email", email);

			return (Account) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	};

	public void addAccount(Account account) {
		this.em.persist(account);
	}
}