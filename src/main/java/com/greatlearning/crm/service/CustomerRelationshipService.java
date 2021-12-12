package com.greatlearning.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.crm.entity.Customer;

@Service
public interface CustomerRelationshipService {

	public List<Customer> findAll();

	public void save(Customer customer);

	public Customer findById(int id);

	public void deleteById(int id);
}
