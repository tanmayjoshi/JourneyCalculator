package com.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.Business.JourneyService;
import com.test.Model.JourneyDetails;

@RestController
public class JourneyController {
	
	@Autowired
	JourneyService journeyService;
	
	@GetMapping("/generateDummyJourneys")
	public List<JourneyDetails> generateDummyJourneys(){
		
		return journeyService.createJourneyList();
	}
	
	@GetMapping("/getJourneys")
	public List<JourneyDetails> getJourneys(){
		
		return journeyService.getJourneyList();
	}
	
	
	@PostMapping("/addJourney")
	public List<JourneyDetails> addJourney(@RequestBody JourneyDetails journeyDetails) throws Exception{
		
		return journeyService.addJourney(journeyDetails);
	}

}
