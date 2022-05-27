package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.accenture.lkm.Calculator;

@TestInstance(Lifecycle.PER_METHOD)
public class CalculatorTestLifeCycle {
	
	static Calculator calc;
	/* to set up data and objects 
	 * executes once in the beginning
	 */
	@BeforeAll
	static void setUpBeforeClass() {
		
		calc=new Calculator();
		System.out.println("@BeforeAll executed");
	}
	/* to destroy any test data /objects 
	 * executes after all test methods finish
	 */

	@AfterAll
	static void tearDownAfterClass() {
		calc=null;
		System.out.println("@AfterAll executed");
	}
	
	/*to set up data and objects
	 *executes before each test method
	 */
	@BeforeEach
	void setUp() {
		System.out.println("--@BeforeEach Executed");
	}
	

	/*to destroy data and objects
	 *executes after each test method
	 */
	@AfterEach
	void tearDown() throws Exception  {
		System.out.println("--@AfterEach executed");
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
