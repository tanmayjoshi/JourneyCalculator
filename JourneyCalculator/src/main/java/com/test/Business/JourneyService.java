package com.test.Business;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Model.Customer;
import com.test.Model.CustomerTypes;
import com.test.Model.JourneyDetails;
import com.test.Store.CustomeDetails;
import com.test.Store.JourneyRoutesDetails;
import com.test.Utilities.DateUtils;

@Service
public class JourneyService {

	@Autowired
	JourneyRoutesDetails journeyRoutesDetails;
	
	@Autowired
	CustomeDetails customeDetails;
	
	@Autowired
	CustomerService customerService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JourneyService.class);
	
	public List<JourneyDetails> createJourneyList(){
		return journeyRoutesDetails.createJourneys();
	}

	public List<JourneyDetails> getJourneyList(){
		return journeyRoutesDetails.getJourneyList();
	}
	
	public List<JourneyDetails> addJourney(JourneyDetails journeyDetails) throws Exception {
		List<Customer> customers = customeDetails.getCustomers();
		if(customeDetails.getCustomers().stream().anyMatch(c -> c.getId() == journeyDetails.getId())) {
			journeyDetails.setJournetDateTime(DateUtils.stringToDate(journeyDetails.getJourneyTime()));
			setFavouriteRoute(customers,journeyDetails);
			return journeyRoutesDetails.addJourney(journeyDetails);
		}
		else
			throw new Exception("Customer dose not already exists......");
	}
		
	public void setFavouriteRoute(List<Customer> customers, JourneyDetails journeyDetails) {
		
		Customer customer = customeDetails.getCustomer(journeyDetails.getId());
		List<JourneyDetails> jourLst = journeyRoutesDetails.getJourneyList().stream().filter(j -> j.getId() == journeyDetails.getId()).collect(Collectors.toList());
		jourLst.add(journeyDetails);
		Map<String, Integer> routesVisits =  new HashMap<String, Integer>();
		
		for (JourneyDetails j : jourLst) {
			if(routesVisits.containsKey(j.getRoute())) {
				routesVisits.put(j.getRoute(), routesVisits.get(j.getRoute())+1);
			}else {
				routesVisits.put(j.getRoute(), 1);
			}
		}
		
		String route=routesVisits.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		LOGGER.info("****Favrouite Route "+route+" for Customer ID "+customer.getId());
		calculateFare(journeyDetails, routesVisits);
		customerService.updateCustomerRouteData(customer, route);
	}
	
	public void calculateFare(JourneyDetails journeyDetails, Map<String, Integer> routesVisits) {
		
		Customer customer = customeDetails.getCustomer(journeyDetails.getId());
		List<JourneyDetails> journeyList = journeyRoutesDetails.getJourneyList();
		int baseFare = customer.getType().equalsIgnoreCase(CustomerTypes.VIP.type()) ? 1: 2;
		int discountPercent = 0;
		long currentJournetCount = journeyList.stream().filter(r ->  r.getRoute().equalsIgnoreCase(journeyDetails.getRoute()) && 
				isLessThanTwoHours(journeyDetails.getJournetDateTime())).count();
		
		//If customer's favourite route, then 30% discount 
		if(journeyDetails.getRoute().equalsIgnoreCase(customer.getRoute()) && 
				!customer.getType().equalsIgnoreCase(CustomerTypes.PERSONA_NON_GRANTA.type())) {
			LOGGER.info("****30% Discount applied for favourite Route****");
			discountPercent =  30;
		}
		
		if(currentJournetCount >= 3) {
			LOGGER.info("****Additional 10% Discount applied for frequent Route****");
			discountPercent += 10;
		}
		
		LOGGER.info("****Total Discount****"+discountPercent);
		fareCalculation(discountPercent, baseFare);
	}
	
	public Boolean isLessThanTwoHours(Date date1) {
		if(new Date().getSeconds() - date1.getSeconds() < 7200)
			return true;
		else
			return false;
	}
	
	public void fareCalculation(int discountPercent, int baseFare) {
		float discountedValue = (float)((baseFare*discountPercent)/100f);
		LOGGER.info("Journey Fare is £"+ (baseFare - discountedValue));
	}
}
