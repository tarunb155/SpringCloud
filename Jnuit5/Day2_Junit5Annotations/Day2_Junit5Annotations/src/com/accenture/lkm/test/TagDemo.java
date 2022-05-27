package com.accenture.lkm.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagDemo {

	@Tag("dev")
	@Test
	void test1() {
		System.out.println("I am in test1()");
	}
	
	@Tag("dev")
	@Test
	void test2() {
		System.out.println("I am in test2()");
	}
	
	
	@Tag("prod")
	@Test
	void test3() {
		System.out.println("I am in test3()");
	}
	
	
	
}


