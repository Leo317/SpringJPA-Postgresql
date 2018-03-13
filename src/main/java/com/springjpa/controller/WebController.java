package com.springjpa.controller;

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
	
	private final static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
    ICustomerService iCustomerServ;
	
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
		// save a single Customer
//		repository.save(new Customer(1111, "Jack", "Smith"));
//		
//		// save a list of Customers
//		repository.save(Arrays.asList(new Customer(2222, "Adam", "Johnson"), new Customer(3333, "Kim", "Smith"),
//										new Customer(4444, "David", "Williams"), new Customer(5555, "Peter", "Davis")));
		
		return "Done";
	}
	
	@PostMapping(value = "/creat")
	public ResponseEntity creat(@RequestBody Customer customer) throws CustomerTransactionException{
//		try {
//			iCustomerServ.creat(customer);
//			System.out.println("Creat successfully");
//	      } catch (CustomerTransactionException e) {
//	          e.printStackTrace();
//	      }
		
		iCustomerServ.creat(customer);
		return new ResponseEntity(customer, HttpStatus.OK);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Delete Id = " + id;
	}

	@RequestMapping("/findall")
	public String getAll(){
//		String result = "";
//		
//		for(Customer cust : repository.findAll()){
//			result += cust.toString() + "<br>";
//		}
//		
//		return result;
		return iCustomerServ.getAll();
	}
	
//	@RequestMapping("/findbyid")
//	public Customer findById(@RequestParam("id") long id){
////		String result = "";
////		result = repository.findOne(id).toString();
////		return result;
//		Session session = sessionFactory.openSession();
//
//        Customer customer = session.get(Customer.class, id);
//     
//        session.close();
//        return customer;
//	}
//	
//	@RequestMapping("/findbyphone")
//	public String fetchDataByPhone(@RequestParam("phone") long phone){
//		String result = "";
//		
//		for(Customer cust: repository.findByPhone(phone)){
//			result += cust.toString() + "<br>"; 
//		}
//		
//		return result;
//	}
//	
//	@RequestMapping("/findbyfirstname")
//	public String fetchDataByFirstName(@RequestParam("firstname") String firstname){
//		String result = "";
//		
//		for(Customer cust: repository.findByFirstName(firstname)){
//			result += cust.toString() + "<br>"; 
//		}
//		
//		return result;
//	}
//	
//	@RequestMapping("/findbylastname")
//	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
//		String result = "";
//		
//		for(Customer cust: repository.findByLastName(lastName)){
//			result += cust.toString() + "<br>"; 
//		}
//		
//		return result;
//	}
}

