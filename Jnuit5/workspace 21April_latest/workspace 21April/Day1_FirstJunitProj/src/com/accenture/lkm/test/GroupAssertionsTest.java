package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupAssertionsTest {
	
	private static final String FIRST_NAME="Jane";
	private static final String LAST_NAME="Doe";
	private Person person;
	
	
	@BeforeEach
	void createPerson() {
		
		person=new Person();
		person.setFirstName(FIRST_NAME);
		person.setLastName("Potter");
	}

	@Test
	void shouldHaveCorrectName() {
		
		assertAll("Name",()->assertEquals(FIRST_NAME,person.getFirstName(),"The firstName is incorrect"),
				
				         ()->assertEquals(LAST_NAME,person.getLastName(),"The LastName is incorrect")
				
				);
		
		
		
	}
	
	
	
	
}
