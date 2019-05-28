package com.test.Model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.internal.util.IgnoreJava6Requirement;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JourneyDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3996468243379038906L;

	
	private int id;
	private String journeyTime;
	private String route;
	@JsonIgnore
	private Date journetDateTime;
	@JsonIgnore
	private int numberOfTravels;
	
	public JourneyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JourneyDetails(int id, String journeyTime, String route, int numberOfTravels) {
		super();
		this.id = id;
		this.journeyTime = journeyTime;
		this.route = route;
		this.numberOfTravels = numberOfTravels;
	}
	
	public JourneyDetails(int id, String journeyTime, String route, Date journetDateTime, int numberOfTravels) {
		super();
		this.id = id;
		this.journeyTime = journeyTime;
		this.route = route;
		this.journetDateTime = journetDateTime;
		this.numberOfTravels = numberOfTravels;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public int getNumberOfTravels() {
		return numberOfTravels;
	}
	public void setNumberOfTravels(int numberOfTravels) {
		this.numberOfTravels = numberOfTravels;
	}
	public Date getJournetDateTime() {
		return journetDateTime;
	}
	public void setJournetDateTime(Date journetDateTime) {
		this.journetDateTime = journetDateTime;
	}
	
	@Override
	public String toString() {
		return "JourneyDetails [id=" + id + ", journeyTime=" + journeyTime + ", route=" + route + ", journetDateTime="
				+ journetDateTime + ", numberOfTravels=" + numberOfTravels + "]";
	}
	
}
