package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "phone")
	private long phone;
	
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	public Customer() {
	}

	public Customer(long phone, String firstName, String lastName) {
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public long getPhone() {
		return phone;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, phone=%d, firstName='%s', lastName='%s']", id, phone, firstName, lastName);
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
