package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

public class AssumptionsTest {

	/*
	 *The assumeFalse() method validates the given assumption to false 
	 *nd if the assumption is false – test proceed
	 *otherwise, test execution is aborted.
	 */
	@Test
	void testAssumeFalse() {
		System.setProperty("DB", "UAT");
		assumeFalse("UA".equals(System.getProperty("DB")),"Assumptions is True");
		System.out.println("TestAssumeFalse()");
		
		
		
	}
	
	@Test	
	void testAssumeTrue() {
		System.setProperty("DB", "Live");
		assumeTrue("Liv".equals(System.getProperty("DB")),"Assumptions is false");
		System.out.println("TestAssumeTRUE()");
	}
	
	@Test
	void testingThat() {
		assumingThat(2<1, ()->System.out.println("This Must be true"));
	}
	
}
