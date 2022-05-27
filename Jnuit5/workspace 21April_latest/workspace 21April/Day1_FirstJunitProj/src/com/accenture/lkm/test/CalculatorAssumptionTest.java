package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.accenture.lkm.Calculator;

@DisplayName("Assumptionscheck")
public class CalculatorAssumptionTest {

	Calculator calc;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("DB", "Oracle");
		calc = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		calc=null;
	}
	
	
	@Test
	void testAdd_PositiveNum() {
		
		int  input1=4;
		int input2=0;
		assumeTrue(input1>0);
		assumeTrue(input2>0);
		
		int result = calc.add(input1, input2);
		assertEquals(9, result);
		System.out.println("The Result is "+result);
	}
	@Test
	@DisplayName("DividePositiveCheck")
	void testDivide_PositiveNum() {
		
	int input1=4;
	int input2=0;
	assumeTrue(input1>0);
	assumeTrue(input2!=0);
	System.out.println("Test continue");
	int result = calc.add(input1, input2);
	assertEquals(9, result);	
	}
	
	
	@Test
	void testAdd_Num() {
		assumingThat( System.getProperty("DB").equals("Oracle"),
				 () -> {
		                // perform these assertions only on the DB server
		                assertEquals(2, calc.divide(4, 2));
		            });
		
	}
	
	
	


}
