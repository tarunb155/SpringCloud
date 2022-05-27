package com.accenture.lkm.test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest2 {

	int iValue1;
	int iValue2;
	int iValue3;
	int iValue4;

	private void methodThatThrowsException() {

		System.out.println(iValue1 / iValue2);
		System.out.println(iValue1 / iValue3);
	}

	@BeforeEach
	void setup() {

		iValue1 = 100;
		iValue2 = 200;
		iValue3 = 0;
		iValue4 = 200;
	}

	@Test
	public void testAssertionsConditional() {
		// validate condition is true
		assertTrue(iValue1 < iValue2);
	}

	@Test
	public void testAssertionEquals() {
		// validate two strings are equal
		assertEquals(iValue2, iValue4);
		assertEquals(iValue2, iValue4, () -> "Value are equal");

	}

	@Test
	void testExceptionThrows() {
		assertThrows(ArithmeticException.class, () -> methodThatThrowsException());

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("Invalid argument entered!!");
		});

		System.out.println(exception.getMessage());

	}

}
