package com.test.Business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Model.Customer;
import com.test.Store.CustomeDetails;

@Service
public class CustomerService {
	
	@Autowired
	CustomeDetails customeDetails;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	/*Generate Dummy Customers
	 * 
	 */
	public List<Customer> generateCustomers() {
		return customeDetails.createCustomers();
	}
	
	/*
	 * Get Customers whenever required
	 */
	public List<Customer> getCustomers() {
		return customeDetails.getCustomers();
	}
	
	/*
	 * Add Customer if previously no customer is available
	 */
	public List<Customer> addCustomer(Customer customer) throws Exception {
		if(customeDetails.getCustomers().stream().anyMatch(c -> c.getId() == customer.getId()))
			throw new Exception("Customer already exists......");
		else
			return customeDetails.addCustomer(customer);
	}
	
	public void updateCustomerRouteData(Customer customer, String route) {
		customeDetails.alterCustomerRouteData(customer, route);
	}

}
