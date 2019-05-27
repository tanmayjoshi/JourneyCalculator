package com.test.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.Business.JourneyService;

public class DateUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);
	
	public static Date stringToDate(String str) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		Date date = null;
	    try
	    {
	        date = simpleDateFormat.parse(str);

	        LOGGER.info("Date : "+simpleDateFormat.format(date));
	        
	    }
	    catch (ParseException ex)
	    {
	        System.out.println("Exception "+ex);
	    }
		return date;
	}

}
