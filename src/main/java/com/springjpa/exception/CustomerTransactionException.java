package com.springjpa.exception;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerTransactionException extends Exception {
	
	@Autowired
    SessionFactory sessionFactory;
    private static final long serialVersionUID = -3128681006635769411L;
     
    public CustomerTransactionException(String message) {
        super(message);
    }
    
    public void DeleteTransactionException() {
    	System.out.println("DELETE");
    	
    }
}