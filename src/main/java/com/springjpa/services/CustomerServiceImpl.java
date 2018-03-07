package com.springjpa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.dao.CustomerDaoImpl;
import com.springjpa.exception.CustomerTransactionException;
import com.springjpa.model.Customer;

@Service("customerService")
@Transactional(rollbackFor = CustomerTransactionException.class)
public class CustomerServiceImpl implements ICustomerService {
	
	private final static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerDaoImpl customerDao;
	
	@Override
	public void initData(Customer customer) {
		logger.info("Init Data = " + customer);
		customerDao.initData(customer);
	}
	
	@Override
	public void creat(Customer customer) throws CustomerTransactionException {
		if (customer.getPhone() == 5) {
			throw new CustomerTransactionException("phone == 5");
		}
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
