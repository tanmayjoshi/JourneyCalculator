# JourneyCalculator
Application that will store new customers, journeys and price journeys based

Requirements:
1. jdk 1.8+
2. Maven

Prerequisite

This is a journey application. Where the customer are been given discounts of the type of customer and the frequency of the traveling along with the travel routes they follow 

1. This is a maven based Springboot application.
2. The endpoints are accessible using swaggerUI.
3. Start the application and hit the URL :  http://localhost:8080/swagger-ui.html#/
4. All the endpoints will be accessible from here


Steps To Follow:

1. CustomerController.generateDummyCustomers : run this endpoint to get dummy customer data
2. CustomerController.getCustomers : display customer data
3. CustomerController.addCustomer : to add the customer. Error is thrown when customer is already available
	 {
		"id": 1,
		"type": "VIP",
		"name": "Jhon",
		"route": "Madely Street"
	  }
	  
4. JourneyController.generateDummyJourneys : run this endpoint to get dummy journey data
5. JourneyController.getJourneys :  display journeys data
6. JourneyController.addJourney : On adding the journey. THe Journey is added against a particular customer and the fares are been calculate
	 {
		"id": 1,
		"journeyTime": "2019/05/27/22:00:34",
		"route": "Nehru Nagar"
	  }
	  
Note : 1. Please follow the date time format as "2019/05/27/22:00:34" --> "yyyy/MM/dd/HH:mm:ss" \n
       2. Please Verfify the console output


