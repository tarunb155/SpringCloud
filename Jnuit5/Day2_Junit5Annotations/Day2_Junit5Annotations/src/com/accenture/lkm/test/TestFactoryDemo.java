package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import com.accenture.lkm.MyCalculator;

/*
 * Use of @TestFactory
 * Used for creating Dyamic Test
 * A Dynamic Test is a test generated during runtime..
 * It is composed of displayName and Executable
 * @TestFactory method must return a stream,Collection,Iterable or Iterator
 * *
 */
public class TestFactoryDemo {

MyCalculator calc;
	
	@BeforeEach
	void setUp() {
	calc=new MyCalculator();	
	}
	
	@AfterEach
	void tearDown() {
		calc=null;
	}
	
	@Test
	void testAdd_PositiveNum() {
		System.out.println("Addition Test:: testAdd_PositiveNum()");
		int result = calc.add(4, 5);
		assertEquals(9, result);
	}
	
	@TestFactory
	Iterable<DynamicTest> dynamicTestWithIterable(){
		
		return Arrays.asList(
				DynamicTest.dynamicTest("Add Test",()->assertEquals(2, calc.add(1, 1))),
				
				DynamicTest.dynamicTest("Multiply Test",()->assertEquals(1, calc.multiply(1, 1)))
				
				);
		
	}
	
	
	@TestFactory
	Iterator<DynamicTest> dynamicTestWithIterator(){
		
		return Arrays.asList(

				DynamicTest.dynamicTest("Add Test", ()->assertEquals(2,calc.add(1, 1))),
				 DynamicTest.dynamicTest("Multiply Test",
					        () -> assertEquals(4, calc.multiply(2, 2)))).iterator();
		
	}
	
	@TestFactory
	Collection<DynamicTest> dynamicTestCollection(){
		return Arrays.asList(
				DynamicTest.dynamicTest("DynamicTest1", ()->assertTrue(true)),
				DynamicTest.dynamicTest("DynamicTest2", ()->{throw new Exception("Exception Example");}),
				DynamicTest.dynamicTest("DynamicTest3", ()->assertFalse(false))
				);
	}
	
	
}
