package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.accenture.lkm.MyCalculator;

public class NestedTestClassDemo {

	MyCalculator calc;
	
	@BeforeEach
	void setUp() {
	System.out.println("NestedDemo::setUp()");
	calc=new MyCalculator();	
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("NestedDemo::tearDown()");
		calc=null;
	}
	
	@DisplayName("Test for Addition of")
	@Nested
	class AdditionTest{
		
		@DisplayName("2 Positive number")
		@Test
		void testAdd_PositiveNum() {
			System.out.println("Addition Test:: testAdd_PositiveNum()");
			int result = calc.add(4, 5);
			assertEquals(9, result);
		}
		
		@DisplayName("2 Negative Number")
		@Test
		void testAdd_NegativeNum() {
			System.out.println("Addition Test::  testAdd_NegativeNum()");
			int result = calc.add(-4, -5);
			assertEquals(-9, result);
		}
		
	}
	
	@DisplayName("test addition of two large numbers")
	@Test
	void testAdd_PositiveLargeNum() {
		System.out.println("NestedDemo::  testAdd_PositiveLargeNum()");
		int result = calc.add(40000, 5000);
		assertEquals(45000, result);
	}
	
	
	
	
	
	
	
}
