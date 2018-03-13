package com.springjpa;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import com.springjpa.model.Customer;
import com.springjpa.services.ICustomerService;

@SpringBootApplication

@EnableAutoConfiguration(exclude = { //
        DataSourceTransactionManagerAutoConfiguration.class})

public class SpringJpaPostgreSqlApplication implements CommandLineRunner{
	
	
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
		
	}
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){    
	    return hemf.getSessionFactory();    
	}
	
	@Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
        return transactionManager;
    }
}
