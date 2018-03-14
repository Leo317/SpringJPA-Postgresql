package com.springjpa.services;

import java.util.List;

import com.springjpa.exception.CustomerTransactionException;
import com.springjpa.model.Customer;

public interface ICustomerService {
	
	public void initData(Customer customer);
	
	public void creat(Customer customer) throws CustomerTransactionException;
	public Customer find(long id);
	public List<Customer> findAll();
	public void update(Customer customer);
	public void delete(long id) throws CustomerTransactionException;
	
	public String getAll();
}
