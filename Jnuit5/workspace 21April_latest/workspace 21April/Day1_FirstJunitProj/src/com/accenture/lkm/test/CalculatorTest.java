package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.accenture.lkm.Calculator;

public class CalculatorTest {

	@Test
	void testAdd_PositiveNum() {
		Calculator calc=new Calculator();
		int actualResult=calc.add(4, 5);
		assertEquals(9, actualResult);
	}
	
	@Test
	void testAdd_NegativeNum() {
		Calculator calc=new Calculator();
        int actual=calc.add(-4, -5);
        assertEquals(-9,actual);
	}
	
	//so on
	@Test
	void testSub_PostiveNum() {
		Calculator calc=new Calculator();
        int actual=calc.sub(40000,5000);
        assertEquals(35000,actual);
	}
	
	@Test
	void testSub_NegativeNum() {
		Calculator calc=new Calculator();
        int actual=calc.sub(-40000,-5000);
        assertEquals(-35000,actual);
	}
}
