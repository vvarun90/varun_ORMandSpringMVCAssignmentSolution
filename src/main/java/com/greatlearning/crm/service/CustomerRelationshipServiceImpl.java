package com.greatlearning.crm.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.crm.entity.Customer;

@Service
public class CustomerRelationshipServiceImpl implements CustomerRelationshipService {

	public SessionFactory sessionFactory;

	public Session session;

	@Autowired
	public CustomerRelationshipServiceImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
		try {

			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {

			session = sessionFactory.openSession();
		}
	}

	@Override
	public List<Customer> findAll() {

		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();
		return customers;
	}

	@Override
	@Transactional
	public void save(Customer customer) {

		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();

	}

	@Override
	public Customer findById(int id) {

		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

	@Override
	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		if (customer != null)
			session.delete(customer);
		tx.commit();

	}

}
