package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import com.accenture.lkm.bean.Bike;

public class BikeDAO {
	
	
	public List<Bike> getBikes(){
		
		List <Bike>  list = new ArrayList<Bike>();
		list.add(new Bike(10001, 160000, "Bullet", "Enfiled"));
		list.add(new Bike(10002, 180000, "RS 200", "Pulsar"));
		list.add(new Bike(10003, 1360000, "Hayabusa", "Suzuki"));
		
		
		
		return list;
	}

}
