package com.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.Business.CustomerService;
import com.test.Model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/generateDummyCustomers")
	public List<Customer> generateDummyCustomers(){
		
		return customerService.generateCustomers();
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	@PostMapping("/addCustomer")
	public List<Customer> addCustomer(@RequestBody Customer customer) throws Exception{
		
		return customerService.addCustomer(customer);
	}

}
