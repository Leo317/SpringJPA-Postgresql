package com.springjpa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.exception.CustomerTransactionException;
import com.springjpa.model.Customer;
import com.springjpa.services.CustomerServiceImpl;
import com.springjpa.services.ICustomerService;

@RestController
public class WebController {
	
	@Autowired
    ICustomerService iCustomerServ;
	
	@PostMapping(value = "/creat")
	public ResponseEntity creat(@RequestBody Customer customer) throws CustomerTransactionException{
		iCustomerServ.creat(customer);
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@RequestMapping("/find/{id}")
	public Customer find(@PathVariable long id){
		return iCustomerServ.find((Long) id);
	}
	
	@RequestMapping("/findalls")
	public List<Customer> findAll(){
		return iCustomerServ.findAll();
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity update(@PathVariable Long id, @RequestBody Customer customer) {
		customer.setId(id);
		iCustomerServ.update(customer);
		
		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public String delete(@PathVariable Long id) {
		try {
			iCustomerServ.delete(id);
		} catch (CustomerTransactionException e) {
			e.DeleteTransactionException();
		}
		return "Delete Id = " + id;
	}
	
	
	
	@RequestMapping("/findall")
	public String getAll(){
		return iCustomerServ.getAll();
	}
	
	
	
	@RequestMapping(value = "svc/v1/public/accounts/{accountNumber}")
	public String getPublicAccountDataLinkedTo(@PathVariable final int accountNumber) {
		System.out.println("Public");
		return "Public Account Linked To: " + accountNumber;
	}
	
	@RequestMapping(value = "svc/v1/private/accounts/{accountNumber}")
	public String getPrivateAccountDataLinkedTo(@PathVariable final int accountNumber) {
		System.out.println("Private");
		return "Private Account Linked To: " + accountNumber;
	}
	
	@RequestMapping(value = "svc/v1/private/admin/accounts/{accountNumber}")
	public String getExtraPrivateAccountDataLinkedTo(@PathVariable final int accountNumber) {
		System.out.println("Extra");
		return "Private Extra Account Linked To: " + accountNumber;
	}
	
	@RequestMapping("/save")
	public String process(){
		System.out.println("save");
		return "Done";
	}
}

