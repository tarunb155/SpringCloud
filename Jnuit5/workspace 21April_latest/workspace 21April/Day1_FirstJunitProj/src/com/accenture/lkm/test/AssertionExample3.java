package com.accenture.lkm.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertionExample3 {

	
	private void methodThatRuns1Mins() throws InterruptedException {
		 Thread.sleep(3000);		
	}

	private void methodThatThrowsException() {
		 String s=null;
		 System.out.println(s.length());
	}

	@Test
	public void  testTimeOutMethods() {
		// used to test long running tasks.
				//If method takes more than specified duration,then test will fail.
		assertTimeout(Duration.ofMinutes(1),()->methodThatRuns1Mins());
		
		
//		String returnVal=assertTimeout(Duration.ofMillis(100),()->{
//			Thread.sleep(200);
//			return "result";
//		});
		
		//System.out.println("timeout result= "+returnVal);
	}
	
	
	@Test
	void testExceptionThrows() {
		//assertThrows(NullPointerException.class,()->methodThatThrowsException());
		
		//Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
	     //   throw new IllegalArgumentException("Invalid argument entered!!");
	    //});
		
		//System.out.println(exception.getMessage());
		
		
	}
	
	@Test
	void testAssertAll() {
		String x="x";
		assertAll("Heading-CheckAll",
				()->Assertions.assertTrue(4==4),
				()->Assertions.assertNotNull(x),
				()->Assertions.assertEquals("Value1","Value2"),
				()->Assertions.assertFalse(x.equals("b"))
				);
	}

	
	}
		
	
	
	

