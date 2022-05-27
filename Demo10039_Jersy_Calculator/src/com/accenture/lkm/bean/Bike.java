package com.accenture.lkm.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bike {
	private Integer bikeId;
	private double price;
	private String bikeName;
	private String company;

	
	public Bike(){
		
	}
	
	public Bike(Integer bikeId, double price, String bikeName, String company) {
		super();
		this.bikeId = bikeId;
		this.price = price;
		this.bikeName = bikeName;
		this.company = company;
	}

	public Integer getBikeId() {
		return bikeId;
	}

	public void setBikeId(Integer bikeId) {
		this.bikeId = bikeId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
