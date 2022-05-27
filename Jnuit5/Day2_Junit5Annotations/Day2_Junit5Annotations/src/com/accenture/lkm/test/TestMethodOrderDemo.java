package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.accenture.lkm.MyCalculator;

/*
 * @TestMethodOrder: 
 * Numeric Order: @Order(numeric Value)
 * AlphanumericOrder: sort test methods alphanumerically based 
 * on names 
 * @TestMethodOrder(Alphanumeric.class)
 */
//@TestMethodOrder(Alphanumeric.class)
@TestMethodOrder(OrderAnnotation.class)
public class TestMethodOrderDemo {

MyCalculator calc;
	
	@BeforeEach
	void setUp() {
	calc=new MyCalculator();	
	}
	
	@AfterEach
	void tearDown() {
		calc=null;
	}
	
	@Order(2)
	@Test
	void testAdd_PositiveNum() {
		System.out.println("testAdd_PositiveNum");
		int result = calc.add(4, 5);
		assertEquals(9, result);
	}
	
	@Order(1)
	@Test
	void testAdd_NegativeNum() {
		System.out.println("testAdd_NegativeNum");
		int result = calc.add(-4, -5);
		assertEquals(-9, result);
	}
	
	@Order(3)
	@Test
	void testAdd_MultiplyNum() {
		System.out.println("testAdd_MultiplyNum");
		int result = calc.add(4, 5);
		assertEquals(9, result);
	}
	
	
}
