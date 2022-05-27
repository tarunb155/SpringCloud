package com.accenture.lkm;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

// exposing calendar class as service by the name cal
@Path("calculator")
public class CalculatorController {
	
	//Exposing this method as get request for the url pattern a+b
	@GET
	@Path("{num1}+{num2}") 
	public String add(@PathParam("num1")double a, @PathParam("num2")double b){	
		return (a+b)+"";
	}
	
	//Exposing this method as get request for the url pattern a-b
	@GET
	@Path("{num1}-{num2}")
	public String sub(@PathParam("num1")double a, @PathParam("num2")double b){
		return (a-b)+"";
	}
	//Exposing this method as POST request for the url pattern mul
	@POST
	@Path("mul")
	public String multiplication(@FormParam("num1")double a, @FormParam("num2")double b){
		System.out.println("here from multiply");
		return (a*b)+"";
	}
	// Form param reads the values from the form 
}
//Send data in post man client in body part under x-www-form-urlencoded with num1 and num2