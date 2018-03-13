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
//		Customer temp = new Customer();
//		temp.setPhone(customer.getPhone());
//		temp.setFirstName(customer.getFirstName());
//		temp.setLastName(customer.getLastName());
		this.sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public void update(Customer customer) {
//		System.out.println(customer);
		boolean hasParam = false, hasFirstParam = false;
		if (customer.getPhone() != 0 || customer.getFirstName() != null || customer.getLastName() != null) 
			hasParam = true;
		
		if (hasParam) {
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			String HQL = "update customer set ";
			if (customer.getPhone() != 0) {
				HQL += "phone=:phone ";
				hasFirstParam = true;
			}
			if (customer.getFirstName() != null && hasFirstParam)
				HQL += ",firstname=:firstname ";
			else if (customer.getFirstName() != null) {
				HQL += "firstname=:firstname ";
				hasFirstParam = true;
			}
			if (customer.getLastName() != null && hasFirstParam)
				HQL += ",lastname=:lastname ";
			else if (customer.getLastName() != null) {
				HQL += "lastname=:lastname ";
				hasFirstParam = true;
			}
			
			HQL += "where id=:id";
			System.out.println(HQL);
			Query query = session.createQuery(HQL);
			if (customer.getPhone() != 0)
				query.setParameter("phone", customer.getPhone());
			if (customer.getFirstName() != null)
				query.setParameter("firstname", customer.getFirstName());
			if (customer.getLastName() != null)
				query.setParameter("lastname", customer.getLastName());
			query.setParameter("id", customer.getId());
			
			try {
				int executeUpdate = query.executeUpdate();
				if (executeUpdate > 0)
					System.out.println("Update Successfully!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			session.getTransaction().commit();
			session.close();
		
		} else {
			System.out.println("No Parameter Update!!!");
		}
	}

	@Override
	public Customer edit(long id) {
		// TODO Auto-generated method stub
		return find(id);
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
	      session.beginTransaction();
	      
	      Customer result = new Customer();
	      result = (Customer)session.load(Customer.class,id);
	      session.delete(result);

		this.sessionFactory.getCurrentSession().delete(result);
	}
	
	@Override
	public Customer find(long id) {
		return (Customer)currentSession().get(Customer.class, id);
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
