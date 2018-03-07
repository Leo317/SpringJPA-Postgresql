package com.springjpa;

import org.apache.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.model.Customer;
import com.springjpa.services.ICustomerService;

@SpringBootApplication
public class SpringJpaPostgreSqlApplication implements CommandLineRunner{
	
	private static final org.apache.log4j.Logger logger = LogManager.getLogger(SpringJpaPostgreSqlApplication.class);
	
	@Autowired
    ICustomerService iCustomerServ;
	
	public static void main(String[] args){
		SpringApplication.run(SpringJpaPostgreSqlApplication.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		// clear all record if existed before do the tutorial with new data
		Customer cs = new Customer(333, "TestFirstName", "LastName");
		iCustomerServ.initData(cs);
		
		logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
	}
	
}
