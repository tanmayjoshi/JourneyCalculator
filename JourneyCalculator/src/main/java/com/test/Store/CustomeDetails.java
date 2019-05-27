package com.test.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.test.Model.Customer;
import com.test.Model.CustomerTypes;

@Repository
public class CustomeDetails {
	
	public volatile List<Customer> customeStore = new ArrayList<Customer>();
	
	/*
	 * Types : VIP, Normal, Persona Non Grata
	 */
	public List<Customer> createCustomers(){
		customeStore.add(new Customer(01, CustomerTypes.VIP.type(), "Amal", "Gandhi Nagar"));
		customeStore.add(new Customer(02, CustomerTypes.NORMAL.type(), "Arjun",  "Nehru Nagar"));
		customeStore.add(new Customer(03,  CustomerTypes.PERSONA_NON_GRANTA.type(), "Saurabh", "Gulf Road"));
		customeStore.add(new Customer(04, CustomerTypes.VIP.type(), "Pratish", "Jungli Maharaj Road"));
		return customeStore;
	}
	
	public List<Customer> getCustomers(){
		return customeStore;
	}
	
	public List<Customer> addCustomer(Customer customer) throws Exception{
		customeStore.add(customer);
		return customeStore;
	}
	
	public void alterCustomerRouteData(Customer customer, String route) {
		
		for(Customer c : customeStore) {
			if(customer.getId() == c.getId()) {
				c.setRoute(route);
			}
		}
	}
	
	public Customer getCustomer(Integer id){
		Map<Integer, Customer> map = new HashMap<Integer, Customer>();
		for(Customer c : customeStore) {
			map.put(c.getId(), c);
		}
		
		return map.get(id);
	}
	

}
