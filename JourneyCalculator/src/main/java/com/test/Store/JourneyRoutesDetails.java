package com.test.Store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.Model.JourneyDetails;
import com.test.Utilities.DateUtils;

@Repository
public class JourneyRoutesDetails {
	
	public volatile List<JourneyDetails> journeyDetailsStore = new ArrayList<JourneyDetails>();
	
	public List<JourneyDetails> createJourneys(){
		journeyDetailsStore.add(new JourneyDetails(1, "2019/05/27/22:00:34", "Nehru Nagar",DateUtils.stringToDate("2019/05/27/22:00:34"), 1));
		return journeyDetailsStore;
	}

	public List<JourneyDetails> getJourneyList(){
		return journeyDetailsStore;
	}
	
	public List<JourneyDetails> addJourney(JourneyDetails journeyDetails){
		journeyDetailsStore.add(journeyDetails);
		return journeyDetailsStore;
	}
}
