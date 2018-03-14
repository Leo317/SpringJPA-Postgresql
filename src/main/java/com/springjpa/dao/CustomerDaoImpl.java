package com.springjpa.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjpa.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {
	
	@Autowired
    SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public void initData(Customer customer) {
		this.sessionFactory.getCurrentSession().save(customer);
	}
	
	@Override
	public void creat(Customer customer) {
		this.sessionFactory.getCurrentSession().save(customer);
	}
	
	@Override
	public Customer find(long id) {
//		return (Customer) this.sessionFactory.getCurrentSession().get(Customer.class, id);
		System.out.println("Find Id DAO");
		return (Customer) this.sessionFactory.getCurrentSession().createQuery(
				"from customer c where c.id = :id").setLong("id", id).uniqueResult();
	}
	
	@Override
	public List<Customer> findAll() {
		System.out.println("Findall DAO");
		return this.sessionFactory.getCurrentSession().createQuery("from customer").list();
	}

	@Override
	public void update(Customer customer) {
		boolean hasParam = false;
		if (customer.getPhone() != 0 || customer.getFirstName() != null || customer.getLastName() != null) 
			hasParam = true;
		
		if (hasParam) {
			Customer result = new Customer();
			
			result.setId(customer.getId());
			
			if (customer.getPhone() != 0)
				result.setPhone(customer.getPhone());
			if (customer.getFirstName() != null)
				result.setFirstName(customer.getFirstName());
			if (customer.getLastName() != null)
				result.setLastName(customer.getLastName());
			
			this.sessionFactory.getCurrentSession().update(result);
		} else {
			System.out.println("No Parameter Update!!!");
		}
	}
	
	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
	    Customer result = new Customer();
	    result = (Customer)session.load(Customer.class,id);
		this.sessionFactory.getCurrentSession().delete(result);
	}

	@Override
	public String getAll() {
		// TODO Auto-generated method stub
//		return currentSession().createCriteria(Customer.class).list();
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        
		Criteria criteria = session.createCriteria(Customer.class);
        List users = criteria.list();
        Iterator iterator =  users.iterator();

        String result = "";
        
        while(iterator.hasNext()) {
        	result += iterator.next().toString() + "<br>";
        }
		return result;
	}

}
