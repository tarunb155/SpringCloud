package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.accenture.lkm.MyCalculator;

public class CalculatorTest_TestInfo {

	MyCalculator calc;
	
	@BeforeEach
////injected TestInfo as param
	void setUp(TestInfo info) {
		calc=new MyCalculator();
		System.out.println("Set Up for method named :" +info.getDisplayName());
	}

	@AfterEach
	void tearDown() throws Exception {
		calc=null;
	}
	@DisplayName("add Method 1")
	@Tag("Positive")
	@Test
	void testAdd_PositiveNum(TestInfo info) {
		System.out.println("Running Method "+ info.getTestMethod().get().getName());
		System.out.println("tags in Method :"+ info.getTags());
		
		assertTrue(info.getTags().contains("Positive"));
		int result = calc.add(4, 5);
		assertEquals(9, result);
	}
	
	
	@DisplayName("Negative Method 1")
	@Tag("Negative")
	@Test
	void testAdd_NegativeNum(TestInfo info) {
		System.out.println("Running Method "+ info.getTestMethod().get().getName());
		System.out.println("tags in Method :"+ info.getTags());
		
		assertTrue(info.getTags().contains("Negative"));
		int result = calc.add(4, 5);
		assertEquals(9, result);
	}

}
