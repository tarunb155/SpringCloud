package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import com.accenture.lkm.MyCalculator;

@EnabledOnJre(JRE.JAVA_8)
public class CalculatorTest_ConditionalTest {

	MyCalculator calc;

	@BeforeEach
	void setUp() throws Exception {
		calc = new MyCalculator();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		calc=null;
	}
	
	//method will run only on window os
	//@EnabledOnOs(OS.WINDOWS)
	@Test
	void testAdd_PositiveNum() {
		System.out.println("testAdd_PositiveNum");
		int result = calc.add(4, 5);
		assertEquals(9, result);
	}
	
	//method will NOT run on Windows OS
		//@DisabledOnOs(OS.WINDOWS)
		@Test
		void testAdd_NegativeNum() {
			System.out.println("testAdd_NegativeNum");
			int result = calc.add(-4, -5);
			assertEquals(-9, result);
		}
	
		@EnabledOnOs(value = {OS.AIX,OS.LINUX})
		@Test
		void testAdd_Zeroes() {
			System.out.println("testAdd_Zeroes");
			int result = calc.add(0, 0);
			assertEquals(0, result);
		}
		
		//method will run only on Java version 8
		//@EnabledOnJre(JRE.JAVA_8)
		@Test
		void testSubtract_PositiveLargeNum() {
			System.out.println("testSubtract_PositiveLargeNum");
			int result = calc.add(40000, 5000);
			assertEquals(45000, result);
		}
		
		//method runs only if env=dev property is found as environmental variable
		//@EnabledIfEnvironmentVariable(named = "PROCESSOR_LEVEL", matches = "6")
		@Test
		void testMultiply_ByZero() {
			int result = calc.multiply(46, 0);
			assertEquals(0, result);
			System.out.println("testMultiply_ByZero");
		}

	
	
}
