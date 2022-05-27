package com.accenture.lkm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssertionExample1 {

	String sValue1;
	String sValue2;
	String sValue3;
	String sValue4;
	String sValue5;
	int iValue1;
	int iValue2;
	
	@BeforeEach
	void setup() {
		sValue1=new String("Junit5");
		sValue2=new String("Junit5");
		sValue3=null;
		sValue4="Junit5";
		sValue5="Junit5";
		
		iValue1=100;
		iValue2=200;
	}
	
	@Test
	public void testAssertionEquals() {
		//validate two strings are equal
		//assertEquals(sValue1, sValue2);
		// overloaded method with failure message
		//assertEquals(sValue1,sValue2,"Value are not equal");
		//overloaded method with lambda as failure message
		//assertEquals(sValue1,sValue2,()->"Value are not equal");
		
		// Validate two strings are  NOT equal
		//assertNotEquals(sValue1,sValue2);
		//assertNotEquals(sValue1,sValue2, "Value are equal");
		
		//overloaded method with lambda as failure message
		//Supplier <String> msg=()->"Values are equal";
		//assertNotEquals(sValue1,sValue2,msg);
		
		// Validate if two objects are same
		assertSame(sValue4,sValue5);
		// Validate if two objects are not same
		assertNotSame(sValue1,sValue4);
		
		
	}
	
	@Test
	public void testAssertionsNull() {
		// Validate object is not null
		//assertNotNull(sValue4);
		//assertNotNull("oops value is null",sValue3 );

		// Validate object is null
		//assertNull(sValue3);
	}
	
	@Test
	public void testAssertionsConditional() {
		//validate condition is true
		//assertTrue(iValue1<iValue2);
		//assertTrue(iValue1 >iValue2, "Condition is False");
		
		assertFalse(iValue1>iValue2);

		
	}
	
	
	
}
