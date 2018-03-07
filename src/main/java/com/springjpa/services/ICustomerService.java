package com.springjpa.services;

import com.springjpa.model.Customer;

public interface ICustomerService {
	
	public void initData(Customer customer);
	public void creat(Customer customer);
	public void update(Customer customer);
	public Customer edit(long id);
	public void delete(long id);
	public Customer find(long id);
	public String getAll();
}
