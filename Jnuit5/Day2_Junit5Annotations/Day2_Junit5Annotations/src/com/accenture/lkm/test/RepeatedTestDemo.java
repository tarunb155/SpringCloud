package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import com.accenture.lkm.MyCalculator;

public class RepeatedTestDemo {

	MyCalculator calc;
	
	@BeforeEach
	void setUp() {
		System.out.println("@BeforeEach()");
		calc=new MyCalculator();
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("@AfterEach()");
		calc=null;
	}
	
	@DisplayName("add()")
	@RepeatedTest(value = 2)
	void test_AddPositiveNumber() {
		System.out.println("Inside test_AddPositiveNumber()");
		int result=calc.add(2, 3);
		assertEquals(5,result);
	}
	//{displayName} {currentRepetition} {totalRepetitions}
	
	@DisplayName("Subtract()")
	//@RepeatedTest(value=3,name="{displayName} {currentRepetition}/{totalRepetitions}")
	@RepeatedTest(value=3 ,name="iteration {currentRepetition} of {totalRepetitions}")
	void testSubtract_PositiveNumber() {
		System.out.println("Inside testSubtract_PositiveNumber()");
		int result=calc.subtract(4, 3);
		assertEquals(1,result);
	}
	
	
	
	@RepeatedTest(value = 2)
	void test_AddNumber(RepetitionInfo r1) {
		System.out.println("This is test_AddNumber # "+ r1.getCurrentRepetition());
		System.out.println("This is test_AddNumber # "+ r1.getTotalRepetitions());
		int result=calc.add(2, 3);
		assertEquals(5,result);
	}
	
}
