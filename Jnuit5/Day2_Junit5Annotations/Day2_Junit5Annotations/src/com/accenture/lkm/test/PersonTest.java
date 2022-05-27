package com.accenture.lkm.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(PersonParameterResolver.class)
public class PersonTest {
	
	
	
	
	@Test
	void testPersonInstance(Person personInstance) {
		
		System.out.println(personInstance);
		
		personInstance.setFirstName("James");
		personInstance.setLastName("Bond");
		System.out.println(personInstance.getFirstName());
		System.out.println(personInstance.getLastName());
	}

}
