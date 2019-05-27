package com.test.Model;

import java.io.Serializable;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5732230755171408514L;
	
	private int id;
	private String type;
	private String name;
	private String route;
	
	public Customer(int id, String type, String name, String route) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.route = route;
	}
	
	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", type=" + type + ", name=" + name + ", route=" + route + "]";
	}
	
}
