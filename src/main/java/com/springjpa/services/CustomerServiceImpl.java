package com.springjpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.dao.CustomerDaoImpl;
import com.springjpa.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerDaoImpl customerDao;

	@Override
	public void initData(Customer customer) {
		customerDao.initData(customer);
	}
	
	@Override
	public void creat(Customer customer) {
		customerDao.creat(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public Customer edit(long id) {
		// TODO Auto-generated method stub
		return customerDao.edit(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		customerDao.delete(id);
	}

	@Override
	public Customer find(long id) {
		// TODO Auto-generated method stub
		return customerDao.find(id);
	}

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
		return customerDao.getAll();
	}
	
}
