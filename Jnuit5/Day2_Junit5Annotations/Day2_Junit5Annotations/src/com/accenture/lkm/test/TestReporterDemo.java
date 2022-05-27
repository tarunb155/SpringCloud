package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import com.accenture.lkm.MyCalculator;

/*
 * TestReporter Is a functional Interface
 * Contain information for Test Run Output
 * It Can be injected as parameter of constructor or any method 
 */
public class TestReporterDemo {
	
	static MyCalculator calc;
	
	@AfterAll
	static void afterAll(TestReporter reporter) {
		reporter.publishEntry("CalculatorTest.afterAll");
	}
	
	@BeforeAll
	static void beforeAll(TestReporter reporter) {
		calc=new MyCalculator();
		reporter.publishEntry("CalculatorTest.BeforeAll");

	}
	
	@Test
	void testAdd_PositiveNum(TestReporter reporter) {
		reporter.publishEntry("checking addition of +ve number");
		int result = calc.add(4, 5);
		assertEquals(9, result);
	}

}
