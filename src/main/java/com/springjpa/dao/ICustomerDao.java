package com.springjpa.dao;

import com.springjpa.model.Customer;

public interface ICustomerDao {
	
	public void initData(Customer customer);
	public void creat(Customer customer);
	public void update(Customer customer);
	public Customer edit(long id);
	public void delete(long id);
	public Customer find(long id);
	public String getAll();
}
