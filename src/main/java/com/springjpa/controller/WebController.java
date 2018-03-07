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
	
	@RequestMapping("/save")
	public String process(){
		// save a single Customer
//		repository.save(new Customer(1111, "Jack", "Smith"));
//		
//		// save a list of Customers
//		repository.save(Arrays.asList(new Customer(2222, "Adam", "Johnson"), new Customer(3333, "Kim", "Smith"),
//										new Customer(4444, "David", "Williams"), new Customer(5555, "Peter", "Davis")));
		
		return "Done";
	}
	
	@PostMapping(value = "/creat")
	public ResponseEntity creat(@RequestBody Customer customer){
		
		try {
			iCustomerServ.creat(customer);
		} catch (CustomerTransactionException e) {
			// TODO Auto-generated catch block
			logger.info("Web Controller~~~");
			e.printStackTrace();
		}
        
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
		
		iCustomerServ.delete(id);
		
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

