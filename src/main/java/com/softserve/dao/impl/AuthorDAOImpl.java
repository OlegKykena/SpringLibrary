package com.softserve.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.dao.AuthorDAO;
import com.softserve.entity.Author;

/**
 * 
 * DAO class for Author entity.
 * 
 * @author OlegKykena
 * @version 1.0
 * @since 25.10.2016
 *
 */
@Repository
@Transactional
public class AuthorDAOImpl extends GenericDAOImpl<Author, Integer> implements AuthorDAO {

	@PersistenceContext
	private EntityManager entityManager;

	protected AuthorDAOImpl() {
		super(Author.class);
	}

	public List<Author> findByFirstName(String firstName) {
		return entityManager.createQuery("SELECT a FROM Author a WHERE a.firstName = :firstName",
				Author.class).setParameter("firstName", firstName).getResultList();
	}

	public List<Author> findByLastName(String lastName) {
		return entityManager.createQuery("SELECT a FROM Author a WHERE a.lastName = :lastName", 
				Author.class).setParameter("lastName", lastName).getResultList();
	}

}
