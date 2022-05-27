package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
@Disabled
public class DisabledClassTest {

	
	@Test
	public void testConcatWithRegularInput() {
		String val1="Hello";
		String val2="World";
		String sVal3="Hello World";
		String result=val1+val2;
		assertEquals(result,sVal3);
	}
}
