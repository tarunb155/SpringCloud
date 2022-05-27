package com.accenture.lkm.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BikeWrapper {

	private List<Bike> list;

	public List<Bike> getList() {
		return list;
	}

	public void setList(List<Bike> list) {
		this.list = list;
	}
	
	
	
	
}
