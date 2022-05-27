package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * 
 * @TestInstance has two modes. One is LifeCycle.PER_METHOD (the default). The other is LifeCycle.PER_CLASS. 
 * The latter enables us to ask JUnit to create only one instance of the
 *  test class and reuse it between tests.
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.accenture.lkm.Calculator;
	
@TestInstance(Lifecycle.PER_CLASS)
public class CalculatorTestLifeCycle2 {
	
	Calculator calc;@BeforeAll
	 void setUpBeforeClass() {
		
		calc=new Calculator();
		System.out.println("@BeforeAll executed");
	}

	@AfterAll
     void tearDownAfterClass() {
		
	/* to set up data and objects 
	 * executes once in the beginning
	 */
	calc=null;
		System.out.println("@AfterAll executed");
	}
	@Test
	void testAdd_PositiveNum() {
		System.out.println("---testAdd_PositiveNum()");
		int result = calc.add(4, 5);
		assertEquals(9, result);
	}
	@Test
	void testAdd_NegativeNum() {
		System.out.println("---testAdd_NegativeNum()");
        int actual=calc.add(-4, -5);
        assertEquals(-9,actual);
	}
	
	
	@Test
	void testSub_PostiveNum() {
		System.out.println("---testSub_PositiveNum()");
        int actual=calc.sub(40000,5000);
        assertEquals(35000,actual);
	}
	
	@Test
	void testSub_NegativeNum() {
		System.out.println("---testSub_NegativeNum()");
        int actual=calc.sub(-40000,-5000);
        assertEquals(-35000,actual);
	}

	
}
