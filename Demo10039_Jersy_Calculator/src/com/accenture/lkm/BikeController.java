package com.accenture.lkm;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accenture.lkm.bean.Bike;
import com.accenture.lkm.bean.BikeWrapper;
import com.accenture.lkm.dao.BikeDAO;

@Path("bikes")
@Produces(MediaType.APPLICATION_JSON)
public class BikeController {
	
	@GET
	@Path("/getDetails")
	public BikeWrapper getBikeDetails(){
		BikeDAO bikeDAO =  new BikeDAO();
		List<Bike> list= bikeDAO.getBikes();
		BikeWrapper bikeWrapper =  new BikeWrapper();
		bikeWrapper.setList(list);
		System.out.println("here");
		return bikeWrapper;
		
	}
}
